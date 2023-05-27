package com.atovio.proxy;

import com.atovio.service.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class ProxyFactory {
    //类中的Filed(字段)设计为接口,目标对象
    Service target;

    //传入目标对象
    public ProxyFactory(Service target) {
        this.target = target;
    }

    //返回动态代理对象
    public Object getProxy() {
        return Proxy.newProxyInstance( //生成动态代理对象

                target.getClass().getClassLoader()/* ClassLoader loader 类加载器，完成目标对象的加载 */,
                target.getClass().getInterfaces()/* Class<?>[] interfaces 目标对象实现的所有接口 */,
                new InvocationHandler() { /* InvocationHandler h 实现代理功能的接口 */
                    public Object invoke(Object proxy/* 创建代理对象 */, Method method/* 目标对象实现的方法 */, Object[] args/* 目标方法的参数 */)
                            throws Throwable {
                        //代理功能
                        System.out.println("预定时间。。。");
                        //代理功能
                        System.out.println("预定场地。。。");

                        //业务功能
                        //target.sing();还是写死了方法的调用，不行
                        Object obj = method.invoke(target, args);//返回的是目标对象实现的方法的返回值

                        //代理功能
                        System.out.println("结算费用。。。");
                        //切记，这个返回的是目标对象实现的方法的返回值
                        return obj;
                    }
                }
        );
    }
}
