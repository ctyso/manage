//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }),
        @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class SqlInterceptor implements Interceptor {
    private static Logger sqlLogger = LoggerFactory.getLogger( "sqlLogger" );

    public SqlInterceptor() {
    }

    @Override
    public Object intercept( Invocation invocation ) throws Throwable {
        long start = System.currentTimeMillis();
        boolean var19 = false;

        Object var5;
        try {
            var19 = true;
            Object e = invocation.proceed();
            var5 = e;
            var19 = false;
        } catch ( Throwable var20 ) {
            throw var20;
        } finally {
            if ( var19 ) {
                long end1 = System.currentTimeMillis();
                long gap1 = end1 - start;
                String statementId1 = this.getStatementId( invocation );
                sqlLogger.debug( statementId1 + " " + gap1 );
            }
        }

        long end = System.currentTimeMillis();
        long gap = end - start;
        String statementId = this.getStatementId( invocation );
        sqlLogger.debug( statementId + " " + gap );
        return var5;
    }

    private String getStatementId( Invocation invocation ) {
        Object[] args = invocation.getArgs();
        if ( args.length > 0 && args[0] instanceof MappedStatement ) {
            MappedStatement statement = (MappedStatement) args[0];
            return statement.getId();
        } else {
            return null;
        }
    }

    @Override
    public Object plugin( Object target ) {
        return Plugin.wrap( target, this );
    }

    @Override
    public void setProperties( Properties properties ) {
    }
}
