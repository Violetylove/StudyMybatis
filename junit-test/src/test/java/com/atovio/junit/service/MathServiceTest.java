package com.atovio.junit.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * 单元测试类
 *
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class MathServiceTest { //名字规范：要测试的类名+Test

    // 一般是一个业务方法对应一个测试方法
    // 测试方法的规范：public void testXxx(){}
    // @Test注解非常重要，被这个注解标注的方法就是一个单元测试方法
    @Test
    public void testSum() {
        //单元测试有两个重要概念：
        //实际值：被测试的业务方法的真正执行结果
        //期望值：执行了业务方法后期望得到的结果
        MathService mathService = new MathService();
        //获取实际值
        int actual = mathService.sum(1, 2);
        //期望值
        int expected = 3;
        //加断言进行测试
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSub() {
        MathService mathService = new MathService();
        int actual = mathService.sub(10, 5);
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }
}
