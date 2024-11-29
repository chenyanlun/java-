package com.atguigu.ioc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    //自动装配注解（DI）：1.IOC容器中查找符合类型的组件 2.设置当前属性（DI）
    //不需要提供Set方法
    //@Resource(name = "userServiceImpl") 相当于下两个注解
    @Autowired
    @Qualifier("newUserServiceImpl")
    private UserService userService;

    public void show(){
        //调用业务层show方法
        String show = userService.show();
        System.out.println("show = " + show);
    }
}
