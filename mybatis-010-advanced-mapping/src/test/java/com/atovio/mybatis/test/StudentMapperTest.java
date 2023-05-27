package com.atovio.mybatis.test;

import com.atovio.mybatis.mapper.StudentMapper;
import com.atovio.mybatis.pojo.Student;
import com.atovio.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class StudentMapperTest {

    @Test
    public void testSelectByIdStep1() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdStep1(3);
        SqlSessionUtil.close(sqlSession);
        System.out.println(student);
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(3);
        SqlSessionUtil.close(sqlSession);
        System.out.println(student);
    }

    @Test
    public void testSelectByAssociation() {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByAssociation(3);
        SqlSessionUtil.close(sqlSession);
        System.out.println(student);

    }
}
