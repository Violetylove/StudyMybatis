mybatis小技巧

1. #{}和${}的区别

    #{}的执行结果:
        CarMapper.selectByCarType - ==>  Preparing: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType from t_car where car_type=?
        CarMapper.selectByCarType - ==> Parameters: 燃油车(String)
        CarMapper.selectByCarType - <==      Total: 3

    ${}的执行结果:
        CarMapper.selectByCarType - ==>  Preparing: select id, car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType from t_car where car_type=燃油车
        CarMapper.selectByCarType - ==> Parameters:
        org.apache.ibatis.exceptions.PersistenceException:
        ### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column '燃油车' in 'where clause'
        ### SQL:
        select
            id,
            car_num as carNum,
            brand,
            guide_price as guidePrice,
            produce_time as produceTime,
            car_type as carType
        from
            t_car
        where
            car_type=燃油车
        ### Cause: java.sql.SQLSyntaxErrorException: Unknown column '燃油车' in 'where clause'

    #{}：底层使用PreparedStatement。特点：先进行sql语句的编译，然后给占位符(问号?)传值。
    ${}：底层使用Statement。特点：先进行sql语句的拼接，然后再对sql语句进行编译。
    优先使用#{}，这是原则。避免SQL注入的风险。
    如果需要将sql语句的关键字写入SQL语句中，使用${}。

2. 向SQL语句中拼接表名，就需要${}。
    现实业务当中，可能会存在分表存储数据的情况。
    比如日志表，按日期命名：
        t_log_20230502
        t_log_20230503
        ...
    前端查询表时，将日期以 20230502 格式输入，这种情况使用${}拼接SQL语句

3. 批量删除
    批量删除有两种写法：
        第一种or: delete from t_car where id=1 or id=2 or id=3;
        第二种in: delete from t_car where id in(1,2,3);

4. 模糊查询
    根据汽车品牌查询
    第一种方式：
        '%${brand}%'
    第二种方式：concat函数，这是mysql数据库的一个函数，专门进行字符串拼接。
        concat('%',#{brand},'%')
    第三种方式：
        "%"#{brand}"%"

5. 别名机制
    <!--起别名-->
    <typeAliases>
        <!--自己制定-->
        <typeAlias type="com.atovio.mybatis.pojo.Car" alias="aaa"/>

        <!--使用默认设置，默认为car/Car/CAr/cAr...-->
        <!--<typeAlias type="com.atovio.mybatis.pojo.Car"/>-->

        <!--还有更省事的，指定包名就可以了。自动为包下的所有类起别名，默认为简单名-->
        <package name="com.atovio.mybatis.pojo"/>
    </typeAliases>

6. mybatis-config.xml中的mappers标签
    resource和url属性已经知晓。都是根据属性值，到对应路径下找文件。

    <mapper class="全限定接口名"/>
    class:提供全限定接口名。使用这个属性后，mybatis会去接口的包下找 接口.xml 文件。
    所以，要把xml文件放到包下。
    在IDEA中，我们可以采取这种方式：在resource目录下新建包目录，用 / 对目录分级，再把xml文件放到目录中。
    例如:
        <mapper class="com.atovio.mybatis.mapper.CarMapper"/>
        在resource目录下创建目录，com/atovio/mybatis/mapper。再把文件放置进去。

    还有更方便的，使用package标签，直接指定包。使用package标签替换掉<mapper class="全限定接口名"/>