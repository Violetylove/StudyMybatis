package com.atovio.mybatis.test;

import com.atovio.mybatis.mapper.CarMapper;
import com.atovio.mybatis.pojo.Car;
import com.atovio.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author Winter Yuan
 * @organization AtoVio
 */
public class CarMapperTest {

    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"6666","apache",20.2,"2020-11-11","蒸汽机");
        int count = mapper.insert(car);
        sqlSession.commit();
        System.out.println(count);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(42L);
        sqlSession.commit();
        System.out.println(count);
        SqlSessionUtil.close(sqlSession);
    }
}
