package com.atovio.service.impl;

import com.atovio.service.Service;

/**
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class SuperStarZhou implements Service {
    public void sing() {
        System.out.println("我是周润发，我在唱歌。。。。。。");
    }

    public String show(int age) {
        System.out.println("周润发的show。。。。。。" + age);
        return "Zhou";
    }
}
