package com.baidu.mybatisplus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
