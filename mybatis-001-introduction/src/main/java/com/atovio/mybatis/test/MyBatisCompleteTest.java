package com.atovio.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 采用正规的方式，写一个完整版的MyBatis程序。
 *
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class MyBatisCompleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //开启会话，底层会开启事务
            sqlSession = sqlSessionFactory.openSession();
            // 执行SQL语句，处理相关业务

            int count = sqlSession.insert("insertCar");
            System.out.println(count);

            // 程序执行到这里，没有发生异常，提交事务。终止事务。
            sqlSession.commit();
        } catch (Exception e) {
            //最好回滚事务
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            //关闭会话（释放资源）
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
