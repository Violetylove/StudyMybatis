package com.atovio.mybatis.mapper;

import com.atovio.mybatis.pojo.Car;
import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Car row);

    Car selectByPrimaryKey(Long id);

    List<Car> selectAll();

    int updateByPrimaryKey(Car row);
}