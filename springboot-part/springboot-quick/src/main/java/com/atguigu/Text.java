package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Text {

    public static void main(String[] args){
        SpringApplication.run(Text.class,args);//自动创建IOC容器，启动Tomcat
    }
}
