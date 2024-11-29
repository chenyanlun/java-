package com.atguigu.json;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody //数据直接放进响应体返回，不会走视图解析器。快速查找视图，转发和重定向都不生效了
//@RestController =  @Controller+@ResponseBody
@RequestMapping("json")
public class JsonController {

    @GetMapping("data")
    public User data(){
        User user = new User();
        user.setName("ergouzi");
        user.setAge(3);
        return user;
    }

    @GetMapping("data1")
    public List<User> data1(){
        User user = new User();
        user.setName("ergouzi");
        user.setAge(3);
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }
}
