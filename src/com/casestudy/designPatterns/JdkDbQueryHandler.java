package com.casestudy.designPatterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liujian
 * @create 2019-03-26 18:05
 */
public class JdkDbQueryHandler implements InvocationHandler {

    DbQuery dbQuery = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (dbQuery == null) {
            dbQuery = new DbQueryImpl();
        }
        return dbQuery.request();
    }

    public static DbQuery createJdkProxy() {
        DbQuery jdkProxy = (DbQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                        new Class[]{DbQuery.class},
                        new JdkDbQueryHandler());
        return jdkProxy;
    }
}