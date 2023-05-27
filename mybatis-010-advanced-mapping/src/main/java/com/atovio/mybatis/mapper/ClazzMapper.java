package com.atovio.mybatis.mapper;

import com.atovio.mybatis.pojo.Clazz;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public interface ClazzMapper {

    /**
     * 分步查询第二步：根据cid获取班级信息
     *
     * @param cid
     * @return
     */
    Clazz selectByIdStep2(Integer cid);
}
