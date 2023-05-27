 缓存
 1. 一级缓存 SqlSession
    什么情况下一级缓存会失效？
        * 执行了SqlSession的clearCache方法手动清除缓存
        * 对任一表执行了DML语句(insert,delete,update)，
 2. 二级缓存 SqlSessionFactory
    执行条件：
        * 核心配置文件中默认开启
        * pojo类必须可序列化
        * 映射器配置文件中配置<cache/>
    注意事项：
        提交或关闭后才将一级缓存写入二级缓存。
    失效：
        两次DQL之间执行了了DML的情况下，二级缓存会失效。