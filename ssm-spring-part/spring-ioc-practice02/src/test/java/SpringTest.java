import com.atguigu.config.JavaConfig;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController controller = context.getBean(StudentController.class);
        controller.findAll();


    }
}
