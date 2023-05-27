package com.atovio.bank.utils;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;

/**
 * 工具类，可以动态生成Dao的实现类/代理类
 *
 * @version 1.0
 * @Organization AtoVio
 * @Author Winter Yuan
 * @since 1.0
 */
public class GenerateDaoProxy {

    /**
     * 生成接口的实现类，并创建对象返回
     *
     * @param daoInterface 接口名
     * @return 实现了接口的类对象
     */
    public static Object generate(Class daoInterface) {
        // 类池
        ClassPool pool = ClassPool.getDefault();
        // 制造类(com.atovio.bank.dao.AccountDao --> com.atovio.bank.dao.AccountDaoProxy)
        CtClass ctClass = pool.makeClass(daoInterface.getName() + "Proxy");
        // 制造接口
        CtClass anInterface = pool.makeInterface(daoInterface.getName());
        // 实现接口
        ctClass.addInterface(anInterface);
        // 实现接口中所有的方法
        // 吐了，又是拼接
        // ...
        // 不写了

        // 创建对象
        Object obj = null;
        try {
            Class<?> aClass = ctClass.toClass();
            obj = aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
