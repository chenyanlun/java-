package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> query(@Param("name") String name, @Param("salary") Double salary);

    int update(Employee employee);

    //name为空用salary查，salary空用name查，都空查询全部
    List<Employee> queryChoose(@Param("name") String name, @Param("salary") Double salary);

    //批量
    List<Employee> queryBatch(@Param("ids")List<Integer> ids);
    int deleteBatch(@Param("ids")List<Integer> ids);
    int insertBatch(@Param("list")List<Employee> employeeList);
    int updateBatch(@Param("list")List<Employee> employeeList);
}
