逆向工程的增强版

    * 与简易版的区别是：
        1. CRUD操作都封装成了方法，而这些方法的参数就是CRUD语句的条件。
        2. 而这些条件被写成了CarExample类。这个类中的方法就可以对CRUD的条件进行修改。
        3. 这就是QBC风格：Query By Criteria ,一种查询方式，比较面向对象，看不到sql语句

    * 具体操作请看测试源码(src/test/java/com/atovio/mybatis/test/CarMapperTest.java)