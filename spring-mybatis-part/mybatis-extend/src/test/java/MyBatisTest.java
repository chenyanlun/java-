
import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


public class MyBatisTest {

    private SqlSession session;
    // junit会在每一个@Test方法前执行@BeforeEach方法

    @BeforeEach
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build
                        (Resources.getResourceAsStream("mybatis-config.xml")).openSession();
    }

    @Test //使用分页插件
    public void testOne() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        PageHelper.startPage(1,2);
        List<Employee> list = mapper.queryAll();
        PageInfo<Employee> pageInfo = new PageInfo<>(list);

        System.out.println("pageInfo = " + pageInfo);
        long total = pageInfo.getTotal(); // 获取总记录数
        System.out.println("total = " + total);
        int pages = pageInfo.getPages();  // 获取总页数
        System.out.println("pages = " + pages);
        int pageNum = pageInfo.getPageNum(); // 获取当前页码
        System.out.println("pageNum = " + pageNum);
        int pageSize = pageInfo.getPageSize(); // 获取每页显示记录数
        System.out.println("pageSize = " + pageSize);
        List<Employee> employees = pageInfo.getList(); //获取查询页的数据集合
        System.out.println("employees = " + employees);
    }

    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}