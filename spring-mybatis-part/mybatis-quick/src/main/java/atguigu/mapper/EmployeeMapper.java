package atguigu.mapper;

import atguigu.pojo.Employee;

public interface EmployeeMapper {

    Employee queryById(Integer id);

    int deleteById(Integer id);
}
