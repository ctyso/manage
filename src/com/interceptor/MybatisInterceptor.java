package com.interceptor;


import com.manage.base.Page;
import com.manage.base.PageUtil;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

/**
 * mybatis通用拦截器（执行sql打印，插入或更新实体自动装入字段等）
 *
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }) })
public class MybatisInterceptor implements Interceptor {
	private static Logger logger = LoggerFactory.getLogger(MybatisInterceptor.class);

	public Object intercept(Invocation invocation) throws Throwable {
		Object returnValue = null;
		long start = System.currentTimeMillis();
		boolean updateByPrimaryKeySelective =false;
	/*	BaseEntity target =null;
		try{
			//插入或更新实体自动装入字段
			if(UserContext.isAutoSetField()){
				MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
				String sqlId = mappedStatement.getId();
				Object parameter = null;
				if (invocation.getArgs().length > 1) {
					parameter = invocation.getArgs()[1];
				}
				if(sqlId.indexOf("EntityMapper.insertSelective") != -1 && parameter instanceof BaseEntity){
					BaseEntity entity =(BaseEntity) parameter;
					Date currentTime =new Date();
					String currentUserId = UserContext.getUserId();
					EntityUtil.setFieldValueByFieldName(entity, "insertTime", currentTime);
					EntityUtil.setFieldValueByFieldName(entity, "updateTime", currentTime);
					if(StringUtils.isNotBlank(currentUserId)) {
						EntityUtil.setFieldValueByFieldName(entity, "insertUser", currentUserId);
						EntityUtil.setFieldValueByFieldName(entity, "updateUser", currentUserId);
					}
				}
				if(sqlId.indexOf("EntityMapper.updateByPrimaryKeySelective") != -1 && parameter instanceof BaseEntity && (parameter instanceof BatchLockEntity ==false)){
					BaseEntity entity =(BaseEntity) parameter;
					updateByPrimaryKeySelective =true;
					target =entity;
					Date currentTime =new Date();
					String currentUserId = UserContext.getUserId();
					EntityUtil.setFieldValueByFieldName(entity, "updateTime", currentTime);
					if(StringUtils.isNotBlank(currentUserId)) {
						EntityUtil.setFieldValueByFieldName(entity, "updateUser", currentUserId);
					}
				}
			}
		}catch (Throwable e) {
		}*/
		try {
			returnValue = invocation.proceed();
			//处理更新实体时框架的乐观锁BUG
			if(updateByPrimaryKeySelective && returnValue instanceof Integer){
				Integer updateResult =(Integer) returnValue;
                 if(updateResult ==0){
	                /* if (StringUtils.isNotEmpty(EntityUtil.getVersionFileName(target.getClass()))) {
		                 throw new OptimisticLockException("乐观锁异常，数据被修改、删除 或 未保存！");
	                 }else{
		                 throw new NoResultException(EntityUtil.getTableName(target.getClass()) + "，更新异常，没有被影响的数据！数据的主键是"+target.getId()+"！");
	                 }*/
                 }
			}
		} catch (Throwable e) {
			throw e;
		} finally {
			//打印SQL语句功能
			long end = System.currentTimeMillis();
			long time = (end - start);
			try {
				MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
				String sqlId = mappedStatement.getId();
				if (getIsShow() && time > 0) {
					Object parameter = null;
					if (invocation.getArgs().length > 1) {
						parameter = invocation.getArgs()[1];
					}
					//批处理校验表的更新日志不打印
					if(true){
						BoundSql boundSql = mappedStatement.getBoundSql(parameter);
						Configuration configuration = mappedStatement.getConfiguration();
						String sql = getSql(configuration, boundSql);
						//自动分页后的sql打印调整
						Page page = PageUtil.getPage();
						if(page!=null && mappedStatement.getSqlCommandType()== SqlCommandType.SELECT){
							sql =PageInterceptor.getPageSql(page,sql);
							if(page.isCleanCache()){
								Executor executor = (Executor) invocation.getTarget();
								executor.clearLocalCache();
							}
							PageUtil.removePage();
						}
						if (getIsFormat() && sqlId.indexOf("EntityMapper.") == -1 && sqlId.indexOf("WfMapper.") == -1
								&& sql.length() > 200) {
							sql = new SqlFormatter().format(sql);
							logger.info("\n调用方法：{},{}ms\n查询sql语句：\n{}",sqlId,time, sql);
						} else {
							logger.info("\n调用方法：{},{}ms\n查询sql语句：{}",sqlId,time, sql);
						}
					}
				}
			} catch (Throwable e) {
				PageUtil.removePage();
				logger.error(e.getMessage(),e);
			}
		}
		return returnValue;
	}

	public String getSql(Configuration configuration, BoundSql boundSql) {
		Object parameterObject = boundSql.getParameterObject();
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
		if (parameterMappings.size() > 0 && parameterObject != null) {
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
				sql = sql.replaceFirst("\\?", getParameterValue(parameterObject));

			} else {
				MetaObject metaObject = configuration.newMetaObject(parameterObject);
				for (ParameterMapping parameterMapping : parameterMappings) {
					String propertyName = parameterMapping.getProperty();
					if (metaObject.hasGetter(propertyName)) {
						Object obj = metaObject.getValue(propertyName);
						sql = sql.replaceFirst("\\?", getParameterValue(obj));
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						Object obj = boundSql.getAdditionalParameter(propertyName);
						sql = sql.replaceFirst("\\?", getParameterValue(obj));
					}
				}
			}
		}
		return sql;
	}

	private String getParameterValue(Object obj) {
		String value = null;
		if (obj instanceof String) {
			value = "'" + obj.toString() + "'";
		} else if (obj instanceof Date) {
			DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
			value = "'" + formatter.format(new Date()) + "'";
		} else {
			if (obj != null) {
				value = obj.toString();
			} else {
				value = "null";
			}

		}
		return value;
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	private Boolean isShow=true; // 是否打印sql
	private Boolean isFormat=false; // 是否格式化sql

	private Boolean getIsShow() {
		
		return isShow;
	}

	private Boolean getIsFormat() {
		
		return isFormat;
	}

	public void setProperties(Properties properties) {
	}
}