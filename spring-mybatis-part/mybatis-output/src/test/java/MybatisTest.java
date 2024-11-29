import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.mapper.TeacherMapper;
import com.atguigu.pojo.Employee;
import com.atguigu.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class MybatisTest {
    @Test
    public void test() throws IOException {
        //读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //根据sqlSessionFactory创建sqlSession（每次业务创建一个，用完就释放）+ 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取接口的代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpSalary(888.0);
        employee.setEmpName("二狗子");
        int insertEmp = mapper.insertEmp(employee);
        System.out.println("insertEmp = " + insertEmp);
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {
        //读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //根据sqlSessionFactory创建sqlSession（每次业务创建一个，用完就释放）+ 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取接口的代理对象
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = new Teacher();
        teacher.settName("晒嘿嘿");
        //非自增长ID需自己维护
        //String id = UUID.randomUUID().toString().replaceAll("-"," ");
        //teacher.settId(id);
        int i = mapper.insertTeacher(teacher);
        System.out.println("i = " + i);
        sqlSession.close();
    }
}
