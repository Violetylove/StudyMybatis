package com.atovio.mybatis.test;

import com.atovio.mybatis.mapper.StudentMapper;
import com.atovio.mybatis.pojo.Student;
import com.atovio.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class StudentMapperTest {

    @Test
    public void testSelectTotal() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Long aLong = mapper.selectTotal();
        System.out.println("总记录了条数:" + aLong);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectAllRetMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<Long, Map<String, Object>> map = mapper.selectAllRetMap();
        System.out.println(map);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByNameAndSex2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("张飞", '男');
        students.forEach(System.out::println);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectByNameAndSex() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("张飞", '男');
        students.forEach(System.out::println);
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testInsertStudentByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "张跑");
        map.put("age", 20);
        map.put("height", 1.99);
        map.put("sex", '女');
        map.put("birth", new Date());
        mapper.insertStudentByMap(map);

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    @Test
    public void testSelectBySex() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Character sex = Character.valueOf('男');
        List<Student> students = mapper.selectBySex(sex);

        SqlSessionUtil.close(sqlSession);
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectByBirth() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2023-05-03");
        List<Student> students = mapper.selectByBirth(date);
        SqlSessionUtil.close(sqlSession);
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectByName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("张飞");
        SqlSessionUtil.close(sqlSession);
        students.forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(1L);
        SqlSessionUtil.close(sqlSession);
        students.forEach(System.out::println);
    }
}
