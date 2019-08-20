package com.springcloud.microsso.service.feign;

import com.springcloud.microsso.service.feign.fallback.SwaggerManagerRegisterFeignHystrixFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @copyright: <br> Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @desc: <br>${}<br/>
 * @projectName: <br> micro-parent <br/>
 * @date: <br> 2019/8/12 15:50 <br/>
 * @author: 马雨
 */
@FeignClient(name = "auto-test", fallbackFactory = SwaggerManagerRegisterFeignHystrixFallbackFactory.class)
public interface SwaggerManagerRegisterFeign {

    @PostMapping(value = "v2/client", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void register(Object client);
}
