package com.atovio.mybatis.mapper;

import com.atovio.mybatis.pojo.Student;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public interface StudentMapper {

    /**
     * 分部查询第一步：根据sid查询学生信息
     *
     * @param sid
     * @return
     */
    Student selectByIdStep1(Integer sid);

    /**
     * 一条语句，association
     *
     * @param id
     * @return
     */
    Student selectByAssociation(Integer id);

    /**
     * 通过id查找学生信息及对应的班级信息
     *
     * @param id
     * @return
     */
    Student selectById(Integer id);
}
