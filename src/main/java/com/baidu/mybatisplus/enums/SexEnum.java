package com.baidu.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEnum {
    MAIL(1,"男"),
    FEMAIL(2,"女");

    @EnumValue
    private int sex;
    private String sexName;
    SexEnum(Integer sex,String sexName){
        this.sex = sex;
        this.sexName = sexName;
    }
}
