package com.atovio.mybatis.mapper; // 包名mapper等同于dao

import com.atovio.mybatis.pojo.Car;

import java.util.List;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */

/*
在mybatis中，一般不叫XxxDao,一般叫做XxxMapper。
 */
public interface CarMapper { // 等同于CarDao

    /**
     * 新增Car
     *
     * @param car
     * @return
     */
    int insert(Car car);

    /**
     * 通过id删除Car
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 修改Car信息
     *
     * @param car
     * @return
     */
    int update(Car car);

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Car selectById(Long id);

    /**
     * 获取所有信息
     *
     * @return
     */
    List<Car> selectAll();
}
