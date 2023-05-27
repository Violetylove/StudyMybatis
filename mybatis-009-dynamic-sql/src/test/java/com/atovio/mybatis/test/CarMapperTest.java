package com.atovio.mybatis.test;

import com.atovio.mybatis.mapper.CarMapper;
import com.atovio.mybatis.pojo.Car;
import com.atovio.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class CarMapperTest {

    @Test
    public void testUtil() {
        SqlSession session = SqlSessionUtil.getSession();
        System.out.println(session);
    }

    @Test
    public void testSelectByMultiCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 三个条件都不是空
        List<Car> cars = mapper.selectByMultiCondition("丰田", 5.0, "新能源");
        // 三个条件都是空
        // List<Car> cars = mapper.selectByMultiCondition("", null, "");
        // 后两个为空
        // List<Car> cars = mapper.selectByMultiCondition("丰田", null, "");
        cars.forEach(System.out::println);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void TestSelectByMultiConditionWithWhere() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionWithWhere("丰田", 5.0, "新能源");
        //List<Car> cars = mapper.selectByMultiConditionWithWhere("", null, "");
        cars.forEach(System.out::println);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByMultiConditionWithTrim() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMultiConditionWithTrim("丰田", null, "");
        //List<Car> cars = mapper.selectByMultiConditionWithWhere("", null, "");
        cars.forEach(System.out::println);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(37L, "5454", "潮牌", 22.0, "2020-11-11", "超能源");
        int count = mapper.updateById(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        System.out.println(count);

    }

    @Test
    public void testUpdateBySet() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(39L, "", "坏牌", null, "2029-09-11", "");
        int count = mapper.updateBySet(car);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        System.out.println(count);
    }

    @Test
    public void TestSelectByChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByChoose("丰田", null, null);
        SqlSessionUtil.close(sqlSession);
        cars.forEach(System.out::println);
    }

    @Test
    public void testDeleteByIds() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {37L, 38L, 39L};
        int count = mapper.deleteByIds(ids);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        System.out.println(count);
    }

    @Test
    public void testInsertBatch() {
        SqlSession session = SqlSessionUtil.getSession();
        CarMapper mapper = session.getMapper(CarMapper.class);
        Car car1 = new Car(null, "1200", "帕萨特", 30.0, "2018-11-11", "超能源");
        Car car2 = new Car(null, "1234", "巴萨卡", 14.0, "2033-11-11", "超能源");
        Car car3 = new Car(null, "1131", "阿萨什", 22.0, "2008-11-11", "超能源");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        int count = mapper.insertBatch(cars);
        session.commit();
        SqlSessionUtil.close(session);
        System.out.println(count);
    }
}
