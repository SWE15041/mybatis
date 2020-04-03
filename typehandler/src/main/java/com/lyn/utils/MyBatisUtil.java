package com.lyn.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;
    /*
     * 初始化会话工厂
     */
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream resourceStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 从会话工厂获取会话
     * - 每次都是创建新的会话
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
