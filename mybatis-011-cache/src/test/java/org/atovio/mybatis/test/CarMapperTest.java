package org.atovio.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.atovio.mybatis.mapper.CarMapper;
import org.atovio.mybatis.pojo.Car;
import org.atovio.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class CarMapperTest {

    @Test
    public void testSelectById() throws Exception {
        // 要测试不通的session不能使用SqlSessionUtil工具类。
        // 因为我们设计的是一个线程绑定一个session。
        // SqlSession sqlSession = SqlSessionUtil.getSession();

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();


        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(41L);
        System.out.println(car1);

        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);
        Car car2 = mapper2.selectById(41L);
        System.out.println(car2);

        sqlSession1.close();
        sqlSession2.close();
    }

/*    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.getSession();

        CarMapper mapper1 = sqlSession.getMapper(CarMapper.class);
        Car car1 = mapper1.selectById(41L);
        System.out.println(car1);

        CarMapper mapper2 = sqlSession.getMapper(CarMapper.class);
        Car car2 = mapper2.selectById(41L);
        System.out.println(car2);

        SqlSessionUtil.close(sqlSession);


    }*/

    @Test
    public void testSelectById2() throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        CarMapper mapper1 = sqlSession1.getMapper(CarMapper.class);
        CarMapper mapper2 = sqlSession2.getMapper(CarMapper.class);

        // 不关闭SqlSession对象，二级缓存中没有数据的。
        Car car1 = mapper1.selectById2(41L);
        sqlSession1.close();
        System.out.println(car1);

        Car car2 = mapper2.selectById2(41L);
        sqlSession2.close();
        System.out.println(car2);
    }
}
