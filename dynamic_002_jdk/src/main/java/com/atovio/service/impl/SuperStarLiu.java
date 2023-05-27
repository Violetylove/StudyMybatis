package com.atovio.service.impl;

import com.atovio.service.Service;

/**
 * 目标对象刘德华
 *
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class SuperStarLiu implements Service {
    public void sing() {
        System.out.println("我是刘德华，我在唱歌。。。。。。");
    }

    public String show(int age) {
        System.out.println("刘德华的show。。。。。。" + age);
        return "Liu";
    }

    //此方法不能被代理
    public void doSome() {
        System.out.println("doSome......");
    }
}
