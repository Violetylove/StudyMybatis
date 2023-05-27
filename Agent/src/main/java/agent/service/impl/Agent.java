package agent.service.impl;

import agent.service.Service;

/**
 * 助理：代理对象。
 */
public class Agent implements Service {
    //类中的成员变量设计为接口
    public Service target;

    //传入目标对象，方法的参数设计为接口
    public Agent(Service target) {
        this.target = target;
    }

    public void sing() {
        System.out.println("预定地点。。。");
//        //使用接口动态获取目标对象后，不在这么写，注释掉
//        JayChou Jay = new JayChou();
//        Jay.sing();
        //面向接口编程：调用时，接口指向实现类
        target.sing();
        System.out.println("结算费用。。。");
    }
}
