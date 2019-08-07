package com.springcloud.microcommon.enums.common;

import io.ebean.annotation.EnumValue;
import lombok.Getter;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/25 15:32 <br/>
 * @Author: 玄冥
 */
public enum BooleanEnum {
    /**
     * 肯定
     */
    @EnumValue("1")
    TRUE("是"),
    /**
     * 否定
     */
    @EnumValue("0")
    FALSE("否");

    @Getter
    private String description;

    BooleanEnum(String description) {
        this.description = description;
    }
}
