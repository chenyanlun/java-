package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        updateWrapper.like("name", "a").gt("age", 20)
                .or().isNull("email")
                .set("email",null).set("age",99);
        userMapper.update(null, updateWrapper);

    }
}
