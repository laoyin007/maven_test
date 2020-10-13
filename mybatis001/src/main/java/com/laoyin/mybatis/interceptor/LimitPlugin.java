package com.laoyin.mybatis.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Objects;
import java.util.Properties;

/**
 * @author : yinquan.gong
 * @version V1.0
 * @Description: TODO
 * @date Date : 2020年10月10日 4:36 下午
 */
@Slf4j
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class LimitPlugin implements Interceptor {

    private String dbType;

    private int limit;

    private final static String TEMP_TABLE = "tmp_table";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        while (metaObject.hasGetter("h")) {
            Object object = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(object);
        }

        while (metaObject.hasGetter("target")){
            Object object = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(object);
        }

        String sql = (String) metaObject.getValue("delegate.boundSql.sql");
        String limitSql = null;
        StringBuilder sb = new StringBuilder();
        log.info("intercept sql: {}", sql);
        if(Objects.equals(dbType, "mysql") && !sql.contains(TEMP_TABLE)) {
            sql = sql.trim();
            limitSql = sb.append("select * from (")
                    .append(sql)
                    .append(") ")
                    .append(TEMP_TABLE)
                    .append(" limit ")
                    .append(limit).toString();
            log.info("change sql to {}", limitSql);
            metaObject.setValue("delegate.boundSql.sql", limitSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        dbType = properties.getProperty("dbType", "mysql");
        limit = Integer.parseInt(properties.getProperty("limit", "2"));
    }
}
