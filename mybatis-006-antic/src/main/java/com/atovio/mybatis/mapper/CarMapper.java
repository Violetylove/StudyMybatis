package com.atovio.mybatis.mapper;

import com.atovio.mybatis.pojo.Car;

import java.util.List;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public interface CarMapper {

    /**
     * 使用生成的主键值插入汽车信息
     *
     * @param car
     * @return
     */
    int insertCarUseGeneratedKeys(Car car);

    /**
     * 根据品牌模糊查询汽车信息
     *
     * @param brand
     * @return
     */
    List<Car> selectByBrandLike(String brand);

    /**
     * 批量删除，根据id
     *
     * @param ids
     * @return
     */
    int deleteBatch(String ids);

    /**
     * 查询所有汽车的信息，然后升序(asc)或者降序(desc)
     *
     * @param ascOrDesc
     * @return
     */
    List<Car> selectAllByAscOrDesc(String ascOrDesc);

    /**
     * 根据汽车类型获取汽车信息
     *
     * @param carType
     * @return
     */
    List<Car> selectByCarType(String carType);
}
