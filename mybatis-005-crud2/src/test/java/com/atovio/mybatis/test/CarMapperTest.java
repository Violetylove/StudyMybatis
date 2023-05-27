package com.atovio.mybatis.test;

import com.atovio.mybatis.mapper.CarMapper;
import com.atovio.mybatis.pojo.Car;
import com.atovio.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class CarMapperTest {

    @Test
    public void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        // 获取接口对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "8675", "丰田", 6.0, "2000-10-1", "新能源");
        int count = mapper.insert(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        System.out.println(count);

    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(34L);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(35L, "1175", "丰田222", 6.0, "2000-10-1", "新能源");
        int count = mapper.update(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        System.out.println(count);
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(2L);
        SqlSessionUtil.close(sqlSession);
        System.out.println(car);
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));
    }
}
