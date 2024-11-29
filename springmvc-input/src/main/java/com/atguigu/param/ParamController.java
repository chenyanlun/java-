package com.atguigu.param;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {

    @RequestMapping("data")
    @ResponseBody
    public String data(String name,int age){
        System.out.println("name = " + name + ", age = " + age);
        return "name = " + name + ", age = " + age;
    }

    //value:起名字 required:默认TRUE必须要传，false则是可以没有传参，设置默认值defaultValue
    @GetMapping("data1")
    @ResponseBody
    public String data1(@RequestParam(value = "account") String username,
                        @RequestParam(required = false,defaultValue = "1") int page){
        System.out.println("username = " + username + ", page = " + page);
        return "username = " + username + ", page = " + page;
    }

    //集合接值必须加@RequestParam
    @GetMapping("data2")
    @ResponseBody
    public String data2(@RequestParam List<String> hbs){
        System.out.println("hbs = " + hbs);
        return "hbs = " + hbs;
    }

    //使用实体对象接值
    @GetMapping("data3")
    @ResponseBody
    public String data3(User user){
        System.out.println("user = " + user);
        return user.toString();
    }
}
