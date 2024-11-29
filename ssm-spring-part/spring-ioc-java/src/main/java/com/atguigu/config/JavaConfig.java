package com.atguigu.config;

/*
* java配置类，替代xml文件
* 1.包扫描注解配置- @ComponentScan
* 2.引用外部的配置文件
* 3.申明第三方依赖的bean组件*/

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@ComponentScan("com.atguigu.ioc01")
@PropertySource(value = "classpath:jdbc.properties")
@Configuration //代表是配置类
public class JavaConfig {

    @Value("${atguigu.url}")
    private String url;
    @Value("${atguigu.driver}")
    private String driver;
    @Value("${atguigu.username}")
    private String username;
    @Value("${atguigu.password}")
    private String password;

    /** <bean />的一个方法
     * 方法的返回值类型 == bean组件的类型或他接口和父类
     * 方法的名字 == bean ID
     * @Bean可以让配置类的方法创建的组件存储到IOC容器中*/
    @Bean(name = "zzz")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
