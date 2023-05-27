package com.atovio.mybatis.test;

import com.atovio.mybatis.pojo.Car;
import com.atovio.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class CarMapperTest {

    @Test
    public void testNamespace() {
        SqlSession sqlSession = SqlSessionUtil.OpenSession();
        // List<Object> cars = sqlSession.selectList("selectAll");
        // 正确完整的写法 namespace.id
        List<Object> cars = sqlSession.selectList("aaaaa.selectAll");
        cars.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.OpenSession();
        // 执行SQL语句
        List<Object> cars = sqlSession.selectList("selectAll");
        // 遍历
        cars.forEach(car -> System.out.println(car));//这是啥啊

        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.OpenSession();

        // 执行DQL语句。根据Id查询，查询结果是一条。
        //selectOne方法返回一个结果集对象，然后MyBatis把它封装成java对象。
        Object car = sqlSession.selectOne("selectById", 1);
        System.out.println(car);

        sqlSession.close();
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = SqlSessionUtil.OpenSession();
        //准备数据
        Car car = new Car(4L, "9999", "凯美瑞", 30.0, "1999-09-11", "燃油车");

        //执行sql语句
        int count = sqlSession.update("updateById", car);
        System.out.println(count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.OpenSession();
        int count = sqlSession.delete("deleteById", 6);
        System.out.println(count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPOJO() {
        SqlSession sqlSession = SqlSessionUtil.OpenSession();
        // 封装数据
        Car car = new Car(null, "3333", "比亚迪秦", 30.0, "2020-11-11", "新能源");
        // 执行SQL语句
        int count = sqlSession.insert("insertCar", car);
        System.out.println(count);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar() {
        SqlSession sqlSession = SqlSessionUtil.OpenSession();

        //这个对象我们先使用Map集合进行数据的封装。
       /* Map<String, Object> map = new HashMap<>();
        map.put("k1", "1111");
        map.put("k2", "比亚迪汉");
        map.put("k3", 10.0);
        map.put("k4", "2020-11-11");
        map.put("k5", "电车");*/

        Map<String, Object> map = new HashMap<>();
        map.put("carNum", "1111");
        map.put("brand", "比亚迪汉");
        map.put("guidePrice", 10.0);
        map.put("produceTime", "2020-11-11");
        map.put("carType", "电车");

        //执行sql语句
        //insert方法的参数
        //第一个参数：sqlId,从CarMapper.xml文件中复制。
        //第二个参数：封装数据的对象。
        int count = sqlSession.insert("insertCar", map);
        System.out.println(count);

        sqlSession.commit();
        sqlSession.close();
    }
}
