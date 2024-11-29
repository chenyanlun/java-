import atguigu.mapper.EmployeeMapper;
import atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    @Test
    public void test() throws IOException {
        //读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mybatis-config.xml");
        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        //根据sqlSessionFactory创建sqlSession（每次业务创建一个，用完就释放）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取接口的代理对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println("employee = " + employee);
        //提交事务和释放资源
        //sqlSession.commit();
        sqlSession.close();
    }
}
