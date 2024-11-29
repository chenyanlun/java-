package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestSpring {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);

        List<Long> ids = new ArrayList<>();
        ids.add(1L); ids.add(2L);
        List<User> userList = userMapper.selectBatchIds(ids);
        System.out.println("userList = " + userList);
    }

    @Test
    public void insert(){
        User user = new User();
        user.setEmail("xxx");
        user.setAge(44);
        user.setName("sda");
        int row = userMapper.insert(user);
    }

    @Test
    public void delete(){
        //根据id
        int row = userMapper.deleteById(6);
        System.out.println("row = " + row);
        //根据age
        Map hashMap = new HashMap();
        hashMap.put("age",20);
        int i = userMapper.deleteByMap(hashMap);
        System.out.println("i = " + i);
    }

    @Test
    public void update(){
        //将id=1年龄改为30
        User user = new User();
        user.setId(1L);
        user.setAge(30);
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);

        //所有人年龄改为22
        User user1 = new User();
        user1.setAge(22);
        int update = userMapper.update(user1, null);//null表示没条件
        System.out.println("update = " + update);
    }

    //service
    @Test
    public void save(){
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(18);
        user.setEmail("2eadff");
        user.setName("sad");
        list.add(user);

        User user1 = new User();
        user1.setAge(28);
        user1.setEmail("2ff");
        user1.setName("bad");
        list.add(user1);

        boolean b = userService.saveBatch(list);
        System.out.println("b = " + b);
    }

    @Test
    public void saveOrUpdate(){
        //如果id有值不为空则修改，若为空则保存
        User user = new User();
        user.setAge(17);
        user.setEmail("21f");
        user.setName("sadder");
        boolean b = userService.saveOrUpdate(user);
    }

    @Test
    public void page(){
        Page<User> page = new Page<>(1,3); //(页码，页容量)
        userMapper.selectPage(page,null);
        //page会封装结果
        long current = page.getCurrent(); //页码
        long size = page.getSize();//页容量
        List<User> records = page.getRecords(); //页的当前数据
        long total = page.getTotal();//总条数

    }

    @Test
    public void myPage(){
        Page<User> page = new Page<>(1,3);
        userMapper.queryByAge(page,10);
        long current = page.getCurrent(); //页码
        System.out.println("current = " + current);
        long size = page.getSize();//页容量
        System.out.println("size = " + size);
        List<User> records = page.getRecords(); //页的当前数据
        System.out.println("records = " + records);
        long total = page.getTotal();//总条数
        System.out.println("total = " + total);
    }

}
