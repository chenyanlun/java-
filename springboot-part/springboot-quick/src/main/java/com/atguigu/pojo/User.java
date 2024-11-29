package com.atguigu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @value只能读取单个值，需要把key读全
 * */

@Data
@Component
@ConfigurationProperties(prefix = "cyl.user") //批量读取
public class User {

    //@Value("${cyl.user.username}") di
    private String username; //等于key

    //@Value("${cyl.user.password}")
    private String password;

    private List<String> gfs;
}
