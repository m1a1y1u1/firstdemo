package com.springcloud.microcommon.config;

import com.springcloud.microcommon.domain.Result;
import com.springcloud.microcommon.domain.ResultWrapper;
import com.springcloud.microcommon.enums.ResultCode;
import io.ebean.Ebean;
import io.ebean.PagedList;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @copyright: <br> Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @desc: <br>${}<br/>
 * @projectName: <br> micro-parent <br/>
 * @date: <br> 2019/8/9 22:45 <br/>
 * @author: 马雨
 */
@RestControllerAdvice()
public class GlobalResponseConfig implements ResponseBodyAdvice<Object> {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        e.printStackTrace();
        return ResultWrapper.error(ResultCode.Fast_Fail,"系统异常");
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        return false;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o instanceof PagedList){
            o=Ebean.json().toJson(((PagedList) o).getList());
        }
        return ResultWrapper.valueOf(o);
    }
}
