package com.springcloud.microcommon.enums;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/5 9:44 <br/>
 * @Author: 玄冥
 */
public interface IResultCode {
    /**
     * 响应编码
     *
     * @return
     */
    int getCode();

    /**
     * 响应编码描述
     *
     * @return
     */
    String getDescription();
}
