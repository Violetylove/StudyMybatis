package com.atovio.mybatis.mapper;

import com.atovio.mybatis.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 使用注解进行开发
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public interface CarMapper {

    /**
     * 使用注解插入数据
     * @param car
     * @return
     */
    @Insert("insert into t_car values(null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})")
    int insert(Car car);

    /**
     * 使用注解删除数据
     * @param id
     * @return
     */
    @Delete("delete from t_car where id = #{id}")
    int deleteById(Long id);

    /**
     * 使用Results注解映射返回集属性名
     * @return
     */
    @Select("select * from t_car where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "carNum", column = "car_num"),
            @Result(property = "brand", column = "brand"),
            @Result(property = "guidePrice", column = "guide_price"),
            @Result(property = "produceTime", column = "produce_time"),
            @Result(property = "carType", column = "car_type")
    })
    Car selectById();
}
