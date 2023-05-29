 逆向工程
1. 逆向地生成映射器文件、pojo类、mapper接口。
2. 需要引入mybatis-generator-maven-plugin插件
3. 配置generatorConfig.xml文件，可以去官网(mybatis的官网)查看
    * pojo类名和生成位置
    * 映射器文件SqlMapper.xml文件名和生成位置
    * Mapper接口名和生成位置
    * 数据库连接信息
    * 指定需要参与逆向工程的表
4. 基础版一般，增强版简直就是神！！！太厉害了。

    * 本模块是基础版的实现。
    * mybatis-013-generator2模块是增强版。