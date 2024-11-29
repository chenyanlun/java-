package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("springmvc/hello") //对外访问地址
    @ResponseBody //直接返回字符串给前端不去找视图
    public String hello(){
        System.out.println("HelloController.hello");
        return "hello springmvc!!";
    }
}
