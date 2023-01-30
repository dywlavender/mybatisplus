package com.baidu.mybatisplus.pojo;

import com.baidu.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@TableName("user")
public class User {
    @TableId(value = "uid",type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("username") //表中column名
    private String name;
    private Integer age;
    private String email;

    @TableLogic
    private Integer isDeleted;

    private SexEnum sex;

}
