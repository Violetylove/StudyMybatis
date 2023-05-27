import agent.service.Service;
import agent.service.impl.Agent;
import agent.service.impl.Eason;
import org.junit.Test;

public class MyTest {
    @Test
    public void testAgent() {
//        //有接口和实现类，必须使用接口指向实现类(规范)
//        Service agent = new Agent();
//        agent.sing();
        //面向接口编程
        //也可以先创建Eason对象
        //Service Eason1 = new Eason();
        Service agent = new Agent(new Eason());
        agent.sing();
    }
}
