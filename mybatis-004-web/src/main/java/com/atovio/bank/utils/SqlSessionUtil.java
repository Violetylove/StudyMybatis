package com.atovio.bank.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Mybatis工具类
 * @version 1.1
 * @Organization AtoVio
 * @Author Winter Yuan
 * @since 1.0
 */
public class SqlSessionUtil {

    private static final SqlSessionFactory sqlSessionFactory;

    // 全局的，服务器级别的，一个服务器定义一个即可
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    private SqlSessionUtil() {
    }

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取会话对象
     * @return SqlSession 会话对象
     */
    public static SqlSession OpenSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            // 绑定到当前线程上
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭sqlSession对象
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            local.remove();
        }
    }
}
