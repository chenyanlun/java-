package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //如果是dml语句（插入修改删除）返回Int
    int deleteById(Integer id);

    String queryNameById(Integer id);

    Double querySalaryById(Integer id);

    Employee queryById(Integer id);

    Map<String,Object> selectEmpNameAndMaxSalary();

    //查询工资高于?的员工姓名
    List<String> queryNameBySalary(Double salary);

    int insertEmp(Employee employee);
}
