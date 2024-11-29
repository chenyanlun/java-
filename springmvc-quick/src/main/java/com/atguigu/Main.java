package com.atguigu;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;


public class Main implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //每当web项目启动就会自动调用该方法
        System.out.println("main");
    }
}
