package com.springcloud.microcommon.enums.common;

import io.ebean.annotation.EnumValue;
import lombok.Getter;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/25 14:13 <br/>
 * @Author: 玄冥
 */
public enum GenderTypeEnum {
    @EnumValue("0")
    MALE("男"),
    @EnumValue("1")
    FEMALE("女"),
    @EnumValue("2")
    OTHER("其他");

    @Getter
    private String description;

    GenderTypeEnum(String description) {
        this.description = description;
    }
}
