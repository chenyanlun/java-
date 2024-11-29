package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

//@TableName("user") //一般实体类命名和数据库表名不同时使用，或设置者表名前缀
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableLogic
    //逻辑删除字段 int mybatis-plus下,默认 逻辑删除值为1 未逻辑删除 1
    private Integer deleted;

    @Version //乐观锁版本号
    private Integer version;
}
