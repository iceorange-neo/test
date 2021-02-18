package org.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author neo
 * @date 2021/2/18
 * @time 13:54
 */
public class SqlSessionUtil {

    /**
     *  防止该对象在其他类中被创建对象
     */
    private SqlSessionUtil(){

    }
    private static SqlSessionFactory factory;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程池
     */
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = t.get();
        if(sqlSession == null){
            sqlSession = factory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
            t.remove();
        }
    }
}
