package com.atovio.javassist;

import com.atovio.bank.dao.AccountDao;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Organization AtoVio
 * @Author Winter Yuan
 */
public class JavassistTest {

    @Test
    public void testGenerateAccountDaoImpl() throws Exception {
        // 获取类池
        ClassPool pool = ClassPool.getDefault();
        // 制造类
        String className = "com.atovio.bank.dao.impl.AccountDaoImpl";
        CtClass ctClass = pool.makeClass(className);
        // 制造接口
        CtClass anInterface = pool.makeInterface("com.atovio.bank.dao.AccountDao");
        // 实现接口
        ctClass.addInterface(anInterface);
        // 实现接口中所有的方法
        // 获取接口中所有的方法
        Method[] methods = AccountDao.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            String methodCode = "public void delete(){System.out.println(123456);}";
            try {
                CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
                ctClass.addMethod(ctMethod);
                // 拼接方法

                // ...

                // 不想写，太繁琐了
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        // 在内存中生成class并加载到JVM中
        // 创建对象
        // 调用方法
    }

    @Test
    public void testGenerateImpl() throws Exception {

        // 获取类池
        ClassPool pool = ClassPool.getDefault();
        // 制造类
        String className = "com.atovio.bank.dao.impl.AccountDaoImpl";
        CtClass ctClass = pool.makeClass(className);
        // 制造接口
        CtClass anInterface = pool.makeInterface("com.atovio.bank.dao.AccountDao");
        // 添加接口到类中
        ctClass.addInterface(anInterface);
        // 实现接口中的方法
        // 制造方法
        String methodCode = "public void delete(){System.out.println(123456);}";
        CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
        // 方法添加到类中
        ctClass.addMethod(ctMethod);
        // 在内存中生成类，同时加载到JVM中
        Class<?> aClass = ctClass.toClass();
        AccountDao accountDao = (AccountDao) aClass.newInstance();
        accountDao.delete();
    }

    @Test
    public void testGenerateFirstClass() throws Exception {
        // 获取类池，类池是用来生成class的
        ClassPool pool = ClassPool.getDefault();
        // 制造类,指定全限定类名
        String className = "com.atovio.bank.dao.impl.AccountDaoImpl";
        CtClass ctClass = pool.makeClass(className);
        // 制造方法
        String methodCode = "public void insert(){System.out.println(123456);}";
        CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
        // 将方法添加到类中
        ctClass.addMethod(ctMethod);
        // 在内存中生成class
        ctClass.toClass();

        // 类加载到JVM中,返回 AccountDaoImpl 的字节码
        Class<?> aClass = Class.forName(className);
        // 创建对象
        Object o = aClass.newInstance();
        // 获取AccountDaoImpl实现类的insert方法
        Method insertMethod = aClass.getDeclaredMethod("insert");
        insertMethod.invoke(o);
    }
}
