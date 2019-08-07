package com.springcloud.microcommon.exception;

import com.springcloud.microcommon.enums.ResultCode;
import lombok.Data;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: 统一业务异常类<br />
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/8 13:30 <br/>
 * @Author: 玄冥
 */
@Data
public class BusinessException extends RuntimeException {
    /**
     * 错误码
     **/
    private ResultCode errorCode;
    private String type = "BusinessException-";
    private Object[] msgArgs;
    /**
     * 用于存放后端返回的数据
     **/
    private Object data;

    public BusinessException(ResultCode errorCode, Object data) {
        this.data = data;
        this.errorCode = errorCode;
    }

    public BusinessException(ResultCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public BusinessException(ResultCode errorCode, Object[] msgArgs) {
        this.errorCode = errorCode;
        this.msgArgs = msgArgs;
    }

    public BusinessException(ResultCode errorCode, Object[] msgArgs, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.msgArgs = msgArgs;
    }
}
