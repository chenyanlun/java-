package com.atguigu.requestmapping;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    //@PostMapping("login")
    //  ||
    @RequestMapping(value = "login",method = RequestMethod.POST)//不符合请求方式会405
    public String login(){
        return null;
    }

    @RequestMapping(value = "register",method = {RequestMethod.POST,RequestMethod.GET})
    public String register(){
        return null;
    }
}
