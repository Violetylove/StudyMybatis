package com.atovio.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Mybatis工具类
 *
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class SqlSessionUtil {

    //一个SqlSessionFactory对象对应一个environment，一个environment通常是一个数据库。
    private static final SqlSessionFactory sqlSessionFactory;

    //工具类的方法都是私有化的
    private SqlSessionUtil() {
    }

    //类加载时执行
    //SqlSessionUtil类在第一次加载的时候，解析mybatis-config.xml文件，创建SqlSessionFactory对象。
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取会话对象
     *
     * @return SqlSession 会话对象
     */
    public static SqlSession OpenSession() {
        return sqlSessionFactory.openSession();
    }
}
