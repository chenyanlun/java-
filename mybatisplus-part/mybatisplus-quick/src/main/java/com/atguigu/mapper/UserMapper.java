package com.atguigu.mapper;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    //自己定义一个根据年龄查询，并分页的方法
    IPage<User> queryByAge(IPage<User> page,@Param("age") Integer age);
}
