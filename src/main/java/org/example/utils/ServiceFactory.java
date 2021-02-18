package org.example.utils;

/**
 * @author neo
 * @date 2021/2/18
 * @time 14:28
 */
public class ServiceFactory {

    // 传递目标对象，获取代理对象的过程
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
