package com.atovio;

/**
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class SubSuperStarLiu extends SuperStarLiu {

    //重写父类的方法，增强其功能
    @Override
    public void sing() {
        //子类完成代理功能
        System.out.println("预定时间。。。。。。");
        //子类完成代理功能
        System.out.println("预定地点。。。。。。");

        //父类实现自己的业务
        super.sing();

        //子类完成代理功能
        System.out.println("结算费用。。。。。。");
    }
}
