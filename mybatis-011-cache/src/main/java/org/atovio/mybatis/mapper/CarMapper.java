package org.atovio.mybatis.mapper;

import org.atovio.mybatis.pojo.Car;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public interface CarMapper {

    /**
     * 测试二级缓存
     *
     * @param id
     * @return
     */
    Car selectById2(Long id);

    /**
     * 根据id获取car信息
     *
     * @param id
     * @return
     */
    Car selectById(Long id);
}
