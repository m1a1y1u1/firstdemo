package com.springcloud.microsso.service.feign.fallback;

import com.springcloud.microcommon.enums.ResultCode;
import com.springcloud.microcommon.exception.BusinessException;
import com.springcloud.microsso.service.feign.SwaggerManagerRegisterFeign;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SwaggerManagerRegisterFeignHystrixFallbackFactory implements FallbackFactory<SwaggerManagerRegisterFeign> {
    private Logger logger = LoggerFactory.getLogger(SwaggerManagerRegisterFeignHystrixFallbackFactory.class);

    @Override
    public SwaggerManagerRegisterFeign create(Throwable throwable) {
        logger.error("fallback reason:{}", throwable.getMessage());
        return client -> {
            throw new BusinessException(ResultCode.Fast_Fail, "快速失败！");
        };
    }
}