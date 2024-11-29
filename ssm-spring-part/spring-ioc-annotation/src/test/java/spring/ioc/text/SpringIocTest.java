package spring.ioc.text;

import com.atguigu.ioc01.XxxDao;
import com.atguigu.ioc02.JavaBean;
import com.atguigu.ioc03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

    @Test
    public void testIoc_01(){
        //1.创建IOC容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        //2.获取组件
        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println("bean = " + bean );
        //添加IOC注释，默认的组件名为类的首字母小写
        Object xxxService = applicationContext.getBean("xxxService");
        System.out.println("xxxService = " + xxxService);
        //3.close容器
    }

    @Test
    public void testIoc_02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean = applicationContext.getBean(JavaBean.class);
        JavaBean bean1 = applicationContext.getBean(JavaBean.class);
        System.out.println(bean == bean1);
        applicationContext.close();
    }

    @Test
    public void testIoc_03(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController userController = applicationContext.getBean(UserController.class);
        userController.show();
    }
}
