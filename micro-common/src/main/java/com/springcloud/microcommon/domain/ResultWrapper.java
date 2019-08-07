package com.springcloud.microcommon.domain;

import com.springcloud.microcommon.enums.ResultCode;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/5 9:32 <br/>
 * @Author: 玄冥
 */
@Data
public class ResultWrapper {

    public static Result valueOf(Object data) {
        return new Result(ResultCode.Success, null, null);
    }

    public static Result error(ResultCode resultCode, String msg) {
        if (StringUtils.isBlank(msg)) {
            msg = resultCode.getDescription();
        }
        return new Result(resultCode, msg, null);
    }
}
