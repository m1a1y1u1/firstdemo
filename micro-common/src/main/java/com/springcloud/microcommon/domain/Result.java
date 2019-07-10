package com.springcloud.microcommon.domain;

import com.springcloud.microcommon.enums.ResultCode;
import lombok.Data;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/5 10:00 <br/>
 * @Author: 玄冥
 */
@Data
public class Result {
    private ResultCode code;
    private String msg;
    private Object data;

    public Result(ResultCode code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
