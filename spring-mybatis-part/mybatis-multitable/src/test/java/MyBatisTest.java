import com.atguigu.mapper.CustomerMapper;
import com.atguigu.mapper.OrderMapper;
import com.atguigu.pojo.Customer;
import com.atguigu.pojo.Order;
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

    @Test
    public void testRelationshipToOne() {
    
      OrderMapper orderMapper = session.getMapper(OrderMapper.class);
      // 查询Order对象，检查是否同时查询了关联的Customer对象
        Order order = orderMapper.queryOrderById(1);
        System.out.println(order);
        System.out.println(order.getCustomer());
    
    }

    @Test
    public void testRelationshipToTwo() {

        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        // 查询Order对象，检查是否同时查询了关联的Customer对象
        List<Customer> customers = customerMapper.queryList();
        System.out.println("customers = " + customers);
        for(Customer customer : customers){
            List<Order> orderList = customer.getOrderList();
            System.out.println("orderList = " + orderList);
        }
    }

    // junit会在每一个@Test方法后执行@@AfterEach方法
    @AfterEach
    public void clear() {
        session.commit();
        session.close();
    }
}