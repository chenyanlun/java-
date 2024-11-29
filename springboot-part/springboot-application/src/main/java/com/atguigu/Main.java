package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Text;

@SpringBootApplication
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Text.class,args);//自动创建IOC容器，启动Tomcat
    }
}
