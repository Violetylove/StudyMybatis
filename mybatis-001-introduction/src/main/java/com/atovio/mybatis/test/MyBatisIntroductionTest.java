package com.atovio.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class MyBatisIntroductionTest {
    public static void main(String[] args) throws Exception {

        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象
        //;//Resources.getResourceAsStream默认从类的根路径下查找资源
        //InputStream is = new FileInputStream("");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //获取SqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);//这种方式是不建议的，因为没有开启事务。
        SqlSession sqlSession = sqlSessionFactory.openSession();//如果使用的是JDBC事务管理器，底层会执行con.setAutoCommit(false)。

        //执行SQL语句
        //sqlSession.insert()的参数是id
        int count = sqlSession.insert("insertCar");//返回值是影响数据库表当中的记录条数。

        System.out.println("插入了几条记录:" + count);

        sqlSession.commit();

    }
}
