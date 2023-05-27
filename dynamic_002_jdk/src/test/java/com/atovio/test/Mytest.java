package com.atovio.test;

import com.atovio.proxy.ProxyFactory;
import com.atovio.service.Service;
import com.atovio.service.impl.SuperStarLiu;
import com.atovio.service.impl.SuperStarZhou;
import org.junit.Test;

/**
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class Mytest {

    @Test
    public void testJDK() {

        //创建ProxyFactory对象并将目标对象传进去
        ProxyFactory factory = new ProxyFactory(new SuperStarLiu());
        //获取目标对象的动态代理对象
        Service proxy = (Service) factory.getProxy();
        //通过代理对象调用方法
        proxy.sing();
    }

    @Test
    public void testJDK1() {

        //创建ProxyFactory对象并将目标对象传进去
        ProxyFactory factory = new ProxyFactory(new SuperStarZhou());
        //获取目标对象的动态代理对象
        Service proxy = (Service) factory.getProxy();
        //通过代理对象调用方法
        proxy.show(29);
    }

    @Test
    public void testObject() {
        //创建ProxyFactory对象并将目标对象传进去
        ProxyFactory factory = new ProxyFactory(new SuperStarZhou());
        //获取动态代理对象
        Service proxy = (Service) factory.getProxy();

        //agent是动态代理对象
        System.out.println(proxy.getClass());//class com.sun.proxy.$Proxy4

        //service对象
        Service service = new SuperStarLiu();//com.atovio.service.impl.SuperStarLiu@66cd51c3
        System.out.println(service);
    }
}
