package mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class ConfigurationTest {

    @Test
    public void testEnvironment() throws Exception {
        //获取SqlSessionFactory对象(使用默认方式)
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // Resources.getResourceAsStream方法未指定环境environment，则使用默认指定的环境
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("car.insertCar");
        sqlSession.commit();
        sqlSession.close();

        // 指定环境
        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "mybatis02");
        SqlSession sqlSession1 = sqlSessionFactory1.openSession();
        sqlSession1.insert("car.insertCar");
        sqlSession1.commit();
        sqlSession.close();
    }
}
