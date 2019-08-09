package com.springcloud.microcommon.domain;

import com.springcloud.microcommon.enums.ResultCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/5 10:00 <br/>
 * @Author: 玄冥
 */
@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result(ResultCode codeEnum, String msg, Object data) {
        this.code = codeEnum.getCode();
        this.msg = StringUtils.isBlank(msg) ? codeEnum.getDescription() : msg;
        this.data = data;
    }
}
