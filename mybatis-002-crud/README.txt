使用MyBatis完成CRUD

1. 什么是CRUD
    C: Create
    R: Retrieve
    U: Update
    D: Delete

2. insert
   <insert id="insertCar">
       insert into t_car(id,car_num, brand, guide_price,produce_time,car_type)
       values(null, '1003', '丰田霸道', 30.0, '2000-10-11', '燃油车')
   </insert>
   这种方式，值是写死在配置文件中的。在实际开发中是不存在的。
   一定是前端发来数据，然后将值传给sql语句。

   例如JDBC的写法：
        Sting sql = "insert into t_car(id,car_num, brand, guide_price,produce_time,car_type) values(null, ?, ?, ?, ?, ?);"
        ps.setString(1, Xxx);
        ...

   在MyBatis中不能使用?占位符，必须使用 #{} 来代替JDBC当中的?
         #{} 和 JDBC 中的 ? 是等效的。

   java程序中使用Map可以给SQL语句的占位符传值：
        Map<String, Object> map = new HashMap<>();
        map.put("k1", "1111");
        map.put("k2", "比亚迪汉");
        map.put("k3", 10.0);
        map.put("k4", "2020-11-11");
        map.put("k5", "电车");

        insert into t_car(id,car_num, brand, guide_price,produce_time,car_type) values(null, #{k1}, #{k2}, #{k3}, #{k4}, #{k5})
        注意：#{这里面写map的key，如果key不存在，则获取的是null}

        一般map集合的key起名时要见名知意
            Map<String, Object> map = new HashMap<>();
            map.put("carNum", "1111");
            map.put("brand", "比亚迪汉");
            map.put("guidePrice", 10.0);
            map.put("produceTime", "2020-11-11");
            map.put("carType", "电车");

            insert into t_car(id,car_num, brand, guide_price,produce_time,car_type) values (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType});

        * java程序中使用POJO类给SQL语句占位符传值：
            Car car = new Car(null, "3333", "比亚迪秦", 30.0, "2020-11-11", "新能源");

            注意，占位符#{},大括号里写pojo类的属性名
            insert into t_car(id,car_num, brand, guide_price,produce_time,car_type)
            values (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType});

        * 实际上，mybatis执行的是调用POJO类对象的get方法，而与类中属性名无关。例如：#{carNum}，则调用getCarNum方法，但并不要求对象有carNum属性。
3. delete
    * 需求：根据Id删除数据。
        将id=6的数据删除。

    * 实现：
        int count = sqlSession.insert("insertCar", car);
    <delete id="deleteById">
        delete from t_car where id = #{id}<!--只有一个值，占位符随便写-->
    </delete>

4. update
    * 需求：根据Id修改记录
    <update id="updateById">
        update t_car set
            car_num=#{carNum},
            brand=#{brand},
            guide_price=#{guidePrice},
            produce_time=#{produceTime},
            car_type=#{carType}
        where
            id=#{id}
    </update>

    Car car = new Car(4L, "9999", "凯美瑞", 30.0, "1999-09-11", "燃油车");

5. select (查一个，根据主键查询，)
    * 需求：根据id查询。

    * 实现
        <select id="selectById" resultType="com.atovio.mybatis.pojo.Car">
            select * from t_car where id = #{id}
        </select>

        Object car = sqlSession.selectOne("selectById", 1);

    特别注意：select标签中resultType属性，用来告诉mybatis结果集封装成什么类型的java对象。
        resultType属性值写的是全限定类名。

    但是返回结果不美丽，好多null。原因就是数据库表中列名于java对象属性名不一致。

6. selectAll (查所有)

    <select id="selectAll" resultType="com.atovio.mybatis.pojo.Car">
        select
             id,car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
        from t_car
    </select>

    List<Object> cars = sqlSession.selectList("selectAll");

7. 在sql mapper.xml文件当中有一个namespace属性，这个属性是用来指定命名空间的。用来防止id重复
    使用。
    在xml文件当中：
    <mapper namespace="aaaaa">

        <select id="selectAll" resultType="com.atovio.mybatis.pojo.Car">
            select
            id,car_num as carNum, brand, guide_price as guidePrice, produce_time as produceTime, car_type as carType
            from t_car
        </select>
    </mapper>

    程序中：
    List<Object> cars = sqlSession.selectList("aaaaa.selectAll");
    实际上，id就得这么写：namespace.id
