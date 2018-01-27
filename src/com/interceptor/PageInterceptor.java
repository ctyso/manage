package com.interceptor;

import com.manage.base.Page;
import com.manage.base.PageUtil;
import com.manage.base.ReflectUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * 自动分页拦截器
 * Created by risun on 2017/1/6.
 */
@Intercepts( {
		@Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class}) })
public class PageInterceptor implements Interceptor {
	private static Logger logger = LoggerFactory.getLogger(PageInterceptor.class);
	public Object intercept(Invocation invocation) throws Throwable {
		Page page = PageUtil.getPage();
		if(page!=null){
			RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
			StatementHandler delegate = (StatementHandler) ReflectUtils.getFieldValue(handler, "delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectUtils.getFieldValue(delegate, "mappedStatement");
			if(mappedStatement.getSqlCommandType()== SqlCommandType.SELECT){
				BoundSql boundSql = delegate.getBoundSql();
				Connection connection = (Connection)invocation.getArgs()[0];
				String sql = boundSql.getSql();
				if(page.isSelectTotalRecord()){
					page.setTotalRecord(this.setTotalRecord(boundSql,
							mappedStatement, connection));
				}
				String pageSql = PageInterceptor.getPageSql(page, sql);
				ReflectUtils.setFieldValue(boundSql, "sql", pageSql);
			}
		}
		return invocation.proceed();
	}

	/**
	 * 获得分页sql（postgresql）
	 * @param page
	 * @param sql
	 * @return
	 */
	public static String getPageSql(Page page, String sql) {
		StringBuffer sqlBuffer = new StringBuffer(sql);
		sqlBuffer.append(" limit ").append(page.getPageSize()).append(" offset ").append(page.getRecordStart()-1);
		return sqlBuffer.toString();
	}
	public static String getCountSql(String sql) {
		return "select count(*) from (" + sql + ") countSqlTableName ";
	}
	private int setTotalRecord(BoundSql boundSql,
							   MappedStatement mappedStatement, Connection connection) {
		String sql = boundSql.getSql();
		String countSql = PageInterceptor.getCountSql(sql);
		BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
		//当使用动态 SQL 时，可能会产生临时的参数，这些参数需要手动设置到新的BoundSql中
		Map<String, Object> additionalParameters = (Map<String, Object>) ReflectUtils.getFieldValue(boundSql,"additionalParameters");
		for (String key : additionalParameters.keySet()) {
			countBoundSql.setAdditionalParameter(key, additionalParameters.get(key));
		}
		//由于该分页不支持mybatis的<foreach>标签，这里对该分页做一下更改
		Field metaParamsField = ReflectUtils.getField(boundSql, "metaParameters");
		if (metaParamsField != null) {
			MetaObject mo = (MetaObject) ReflectUtils.getFieldValue(boundSql, "metaParameters");
			ReflectUtils.setFieldValue(countBoundSql, "metaParameters", mo);
		}
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalRecord =0;
		try {
			pstmt = connection.prepareStatement(countSql);
			parameterHandler.setParameters(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalRecord = rs.getInt(1);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(),e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				logger.error(e.getMessage(),e);
			}
		}
		return totalRecord;
	}
	/**
	 * 拦截器对应的封装原始对象的方法
	 */
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/**
	 * 设置注册拦截器时设定的属性
	 */
	public void setProperties(Properties properties) {
	}
}
