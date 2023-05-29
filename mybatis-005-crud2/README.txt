
    这个模块开始引入mybatis的自动生成接口实现类。

    * 之前的模块，我们写好接口类后，还需要自己写实现类。
    * 这个模块后，我们使用SqlSession的getMapper方法来自动生成接口实现类。
    * 其原理来自javassist。详情可以看javassist-test模块