package com.springcloud.microcommon.enums.common;

import io.ebean.annotation.EnumValue;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: micro-parent <br/>
 * @Date: 2019/8/7 11:36 <br/>
 * @Author: 玄冥
 */
public enum QuerySortTypeEnum {
    /**
     * 逆序
     */
    @EnumValue("desc")
    DESC,
    /**
     * 顺序
     */
    @EnumValue("asc")
    ASC;
}
