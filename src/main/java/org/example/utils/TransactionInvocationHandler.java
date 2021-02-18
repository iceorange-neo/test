package org.example.utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author neo
 * @date 2021/2/18
 * @time 14:13
 */
public class TransactionInvocationHandler implements InvocationHandler {

    // 目标对象
    private Object target;

    public TransactionInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    // 代理类的业务方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession = null;
        Object obj = null;
        try{
            sqlSession = SqlSessionUtil.getSqlSession();
            // 处理业务逻辑

            obj = method.invoke(target, args);
            // 提交事务
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally{
            sqlSession.close();
        }
        return obj;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
