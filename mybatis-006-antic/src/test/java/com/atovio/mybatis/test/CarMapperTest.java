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
    public void testInsertCarUseGeneratedKeys() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "88888", "兰博基尼", 200.0, "2020-11-11", "燃油车");
        int count = mapper.insertCarUseGeneratedKeys(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        System.out.println(car);
    }

    @Test
    public void testSelectByBrandLike() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByBrandLike("丰田");
        cars.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testDeleteBatch() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteBatch("32,33");
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        System.out.println(count);
    }

    @Test
    public void testSelectAllByAscOrDesc() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByAscOrDesc("desc");
        cars.forEach(System.out::println);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByCarType() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarType("燃油车");
        SqlSessionUtil.close(sqlSession);
        cars.forEach(car -> System.out.println(car));
    }
}
