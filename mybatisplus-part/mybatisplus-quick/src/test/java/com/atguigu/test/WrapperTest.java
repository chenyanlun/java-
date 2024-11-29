package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a");
        queryWrapper.between("age",20,30);
        queryWrapper.isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
    }

    @Test
    public void test02(){
        ////按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
    }

    @Test
    public void test03(){
        //删除email为空的用户
        //DELETE FROM t_user WHERE (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        //条件构造器也可以构建删除语句的条件
        int result = userMapper.delete(queryWrapper);
    }

    @Test
    public void test04() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE username LIKE ? AND age > ? OR email IS NULL)
        queryWrapper.like("username", "a").gt("age", 20)
                .or().isNull("email");
        User user = new User();
        user.setAge(18);
        user.setEmail("user@atguigu.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test05() {
        //查询用户信息的username和age字段
        //SELECT username,age FROM t_user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("username", "age");
        //selectMaps()返回Map集合列表，通常配合select()使用，避免User对象中没有被查询到的列值为null
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test06(){
        //前端传入了两个参数 name和age
        //name不为空，作为条件 = 查询
        //age>18，作为条件，查询等于age =
        String name = "xx";
        Integer age = 19;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        /**
         * if(StringUtils.isNotBlank(name)){
            queryWrapper.eq("name",name);
        }
        if(age != null && age > 18){
            queryWrapper.eq("age",age);
        }*/
        queryWrapper.eq(StringUtils.isNotBlank(name),"name",name);
        queryWrapper.eq(age != null && age > 18,"age",age);
        userMapper.selectList(queryWrapper);
    }
}
