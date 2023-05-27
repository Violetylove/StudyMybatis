开发我的第一个MyBatis程序

1.resources目录：
    放在这个目录当中的，一般都是资源文件、配置文件。
    直接放到resources目录下的资源，等同于放到了类的根路径下。

2.开发步骤
*第一步：打包方式jar
*第二步：引入依赖
    -MyBatis依赖
    -MySQL驱动依赖
*第三步：编写MyBatis核心配置文件：mybatis-config.xml
    注意：
        第一，这个文件名不是必须叫做mybatis-config.xml。可以用其他的名字，只是大家都用这个名字。
        第二，这个文件的位置也不是固定的，可以随意。但一般情况下，会放到类的根目录下。
*第四步：编写XxxMapper.xml配置文件
    在这个配置文件编写SQL语句。
    这个配置文件名不是固定的，放的位置也不是固定的。我们起个名字，叫做CarMapper.xml，把它暂时放到类的根路径下。
*第五步：在mybatis-config.xml文件中指定XxxMapper.xml文件的路径：
        <mapper resource="CarMapper.xml"/>
        注意：resource属性会自动从类的根路径下查找资源。
*第六步：编写mybatis程序。(使用mybatis的类库，编写mybatis程序，连接数据库，做增删改查就行了。)
    在Mybatis当中，负责执行SQL语句的那个对象叫做啥呢？
        SqlSession
    SqlSession是专门用来执行SQL语句的，是一个Java程序和数据库之间的一次会话。
    要想获取SqlSession对象，要先获取SqlSessionFactory对象，通过SqlSessionFactory工厂来生产SqlSession对象。
    怎么获取SqlSessionFactory对象呢？
        需要首先获取SqlSessionFactoryBuilder对象。
        然后通过SqlSessionFactoryBuilder对象的build方法，来获取一个SqlSessionFactory对象。


    mybatis的核心对象有：
        SqlSessionFactoryBuilder
        SqlSessionFactory,
        SqlSession

    SqlSessionFactoryBuilder --> SqlSessionFactory --> SqlSession

3.从 XML 中构建 SqlSessionFactory
    第一：在MyBatis中有一个很重要的对象，这个对象是：SqlSessionFactory对象。
    第二：SqlSessionFactory对象的创建需要XML。
        XML是一个配置文件。

4.MyBatis中有两个主要的配置文件：
    其中一个是mybatis-config.xml配置文件，这是核心配置文件，主要配置连接数据库的信息等。（一般只有一个）
    另一个是XxxMapper.xml，这个文件是专门用来编写SQL语句的配置文件。（一般是一个表一个）
        例如，t_user表，一般会对应一个UserMapper.xml

5.一些小细节
    * mybatis中sql语句结尾的";"可以省略。
    * Resources.getResourceAsStream
        小技巧：以后凡是遇到resource这个单词，大部分情况下，这种加载资源的方式都是从类的根路径下开始查找。
    * InputStream is = new FileInputStream("");
        采用这种方式也可以。
        缺点：可移植性太差，成不够健壮，可能会移植到其他操作系统，导致路径无效。
    * InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        ClassLoader.getSystemClassLoader() 获取系统的类加载器。
        系统类加载器有一个方法getResourceAsStream，它就是从类路径中加载资源
        通过源代码分析，我们发现：
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml")
            底层源代码其实就是：
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml")
    * CarMapper.xml
6.关于mybatis的事务管理机制。

    * 在mybatis-config.xml文件中，可以通过以下配置进行mybatis的事务管理
        <transactionManager type="JDBC"/>
    * type属性的值有两个：
        JDBC
        MANAGED
    * 在mybatis中提供了两种事务管理机制：
        JDBC事务管理器：
            mybatis框架自己管理事务，自己采用原生的JDBC代码去管理事务：
                con.setAutoCommit(false);开启事务。
                ...业务处理...
                con.commit();手动提交事务
            使用JDBC事务管理器的话，底层创建的事务管理器对象：JdbcTransaction对象。

            如果编写了如下的代码：
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            表示没有开启事务。因为这种方式不会执行：con.setAutoCommit(false);
            在JDBC事务中，没有执行con.setAutoCommit(false);那么AutoCommit就是true。
            如果AutoCommit是true,就表示没有开启事务，只要执行一条DML语句就提交一次。

        MANAGED事务管理器：
            mybatis不再负责事务的管理了。事务管理交给其他容器来负责。例如：Spring。

        JDBC中的事务，如果没有在JDBC代码中执行con.setAutoCommit(true);默认的autoCommit是true
7.关于mybatis集成日志组件。让我们调试起来更加方便。

    * mybatis常见的集成的日志组件有哪些？
        SLF4J (沙拉风) SLF4J是一个日志标准，有一个框架logback实现了沙拉风
        LOG4J
        LOG4J2
        STDOUT_LOGGING
        ...

        SLF4J LOG4J LOG4J2的作者是同一个

    * 其中STDOUT_LOGGING是标准日志，mybatis已经实现了这种日志，只要开启即可。
        在mybatis-config.xml文件中配置settings标签开启
            <settings>
                <setting name="logImpl" value="STDOUT_LOGGING"/>
            </settings>
    * 集成logback日志框架
        logback日志框架实现了SLF4J标准。
        第一步：引入logback的依赖。
                <dependency>
                    <groupId>ch.qos.logback</groupId>
                    <artifactId>logback-classic</artifactId>
                    <version>1.2.11</version>
                    <scope>test</scope>
                </dependency>
        第二部：引入logback必须的配置文件。
            这个配置文件名必须是logback.xml或者logback-test.xml。
            这个文件必须放置在类的根路径下。



