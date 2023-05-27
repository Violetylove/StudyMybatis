package com.atovio.mybatis.mapper;

import com.atovio.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public interface CarMapper {

    /**
     * 批量插入
     *
     * @param cars
     * @return
     */
    int insertBatch(@Param("cars") List<Car> cars);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") Long[] ids);

    /**
     * 使用choose,when,otherwise标签
     *
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByChoose(@Param("brand") String brand,
                             @Param("guidePrice") Double guidePrice,
                             @Param("carType") String carType);

    /**
     * 多条件查询
     *
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiCondition(@Param("brand") String brand,
                                     @Param("guidePrice") Double guidePrice,
                                     @Param("carType") String carType);

    /**
     * 使用where标签
     *
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand,
                                              @Param("guidePrice") Double guidePrice,
                                              @Param("carType") String carType);

    /**
     * 使用trim标签
     *
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand,
                                             @Param("guidePrice") Double guidePrice,
                                             @Param("carType") String carType);

    /**
     * 更新car
     *
     * @param car
     * @return
     */
    int updateById(Car car);

    /**
     * 使用set标签
     *
     * @param car
     * @return
     */
    int updateBySet(Car car);
}
