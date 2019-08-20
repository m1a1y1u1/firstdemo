package com.springcloud.microcommon.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.microcommon.domain.PagedList;
import com.springcloud.microcommon.domain.Result;
import com.springcloud.microcommon.domain.ResultWrapper;
import com.springcloud.microcommon.enums.ResultCode;
import com.springcloud.microcommon.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Arrays;
import java.util.Objects;

/**
 * @copyright: <br> Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @desc: <br>${}<br/>
 * @projectName: <br> micro-parent <br/>
 * @date: <br> 2019/8/9 22:45 <br/>
 * @author: 马雨
 */
@RestControllerAdvice(annotations={RestController.class})
@Slf4j
public class GlobalResponseConfig implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper mapper;

    @ExceptionHandler(BusinessException.class)
    public Result businessException(BusinessException e){
        e.printStackTrace();
        return ResultWrapper.error(e.getErrorCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        e.printStackTrace();
        return ResultWrapper.error(ResultCode.Fast_Fail,"系统异常");
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> converterClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o instanceof io.ebean.PagedList){
            o = new PagedList((io.ebean.PagedList)o);
        }
        try {
            log.debug("{}响应结果：{}", Arrays.toString(Objects.requireNonNull(methodParameter.getMethod()).getDeclaredAnnotations()),mapper.writeValueAsString(o));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResultWrapper.valueOf(o);
    }
}
