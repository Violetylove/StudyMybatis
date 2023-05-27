package com.atovio.mybatis.test;

import com.atovio.mybatis.mapper.CarMapper;
import com.atovio.mybatis.pojo.CarExample;
import com.atovio.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Winter Yuan
 * @organization AtoVio
 */
public class CarMapperTest {

    // CarExample类负责封装查询条件的
    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.getSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        // 执行查询。
        // 1. 查询一个
        System.out.println(mapper.selectByPrimaryKey(41L));
        // 2. 查询所有
        mapper.selectByExample(null).forEach(System.out::println);
        // 3. 根据条件查询
        // QBC风格：Query By Criteria ,一种查询方式，比较面向对象，看不到sql语句
        // 封装条件，通过CarExample封装条件
        CarExample carExample = new CarExample();
        // 调用createCriteria方法来创建查询条件
        carExample.createCriteria()
                .andBrandEqualTo("巴萨卡")
                .andGuidePriceLessThan(new BigDecimal(20.0));
        // 添加or
        carExample.or().andCarTypeEqualTo("超能源");
        // 执行查询
        mapper.selectByExample(carExample).forEach(System.out::println);
        SqlSessionUtil.close(sqlSession);
    }
}
