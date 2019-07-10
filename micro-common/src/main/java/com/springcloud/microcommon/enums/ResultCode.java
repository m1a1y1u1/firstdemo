package com.springcloud.microcommon.enums;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: 返回结果code枚举(业务code) <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/5 9:41 <br/>
 * @Author: 玄冥
 */
public enum ResultCode implements IResultCode{
    /**
     * 成功
     */
    Success(200, "成功请求"),
    /**
     * 失败
     */
    Fast_Fail(700, "快速失败");

    /**
     * 业务响应编码
     */
    private int code;
    /**
     * 编码描述
     */
    private String description;

    ResultCode(int code, String description) {
        this.code = code;
        this.description = description;
    }
    @Override
    public int getCode() {
        return code;
    }
    @Override
    public String getDescription() {
        return description;
    }
}
