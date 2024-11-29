package com.atguigu.ioc03;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class NewUserServiceImpl implements UserService{
    @Override
    public String show() {
        return "NewUserServiceImpl show()";
    }
}
