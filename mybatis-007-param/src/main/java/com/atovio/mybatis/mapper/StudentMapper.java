package com.atovio.mybatis.mapper;

import com.atovio.mybatis.pojo.Student;
import com.sun.istack.internal.NotNull;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public interface StudentMapper {

    /**
     * 获取记录的条数
     *
     * @return
     */
    Long selectTotal();

    /**
     * 使用ResultMap标签进行结果映射，查询所有信息。
     *
     * @return
     */
    List<Student> selectAllByResultMap();

    /**
     * 查询所有信息，返回一个大Map集合
     * 大Map集合的key是主键id
     * 大Map集合的value是每条记录，也是map
     *
     * @return
     */
    @MapKey("id")
    // 将记录里的id作为大Map集合的key
    Map<Long, Map<String, Object>> selectAllRetMap();

    /**
     * 根据姓名和性别查询信息
     * 多参数时，mybatis会自动创建一个map集合，并且map集合是这种形式：
     * map.put(arg0, name)
     * map.put(arg1, sex)
     * map.put(param1,name)
     * map.put(param2, sex)
     *
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSex(String name, Character sex);

    /**
     * Param注解
     * mybatis底层map集合变成：
     * map.put("name", name)
     * map.put("sex", sex)
     *
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSex2(@Param("name") String name, @Param("sex") Character sex);

    /**
     * 通过Map参数保存学生信息
     *
     * @param map
     * @return
     */
    int insertStudentByMap(Map<String, Object> map);

    /*
    当接口中方法的参数只有一个，且参数类型是简单类型。
     */
    List<Student> selectById(Long id);

    List<Student> selectByName(String name);

    List<Student> selectByBirth(Date birth);

    List<Student> selectBySex(Character sex);
}
