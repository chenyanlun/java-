import com.atguigu.config.JavaConfig;
import com.atguigu.ioc01.StudentController;
import com.atguigu.ioc01.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIocTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController bean = applicationContext.getBean(StudentController.class);
        System.out.println("bean = " + bean);
    }
}
