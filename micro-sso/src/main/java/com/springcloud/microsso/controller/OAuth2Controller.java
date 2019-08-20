package com.springcloud.microsso.controller;

import com.springcloud.microcommon.config.swagger.SwaggerConfigProperties;
import com.springcloud.microsso.service.feign.SwaggerManagerRegisterFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @copyright: <br> Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @desc: <br>${}<br/>
 * @projectName: <br> micro-parent <br/>
 * @date: <br> 2019/8/13 9:35 <br/>
 * @author: 马雨
 */
@Api("OAuth2授权相关接口")
@RestController
@RequestMapping("/sso/oauth2")
public class OAuth2Controller {

    @Autowired
    private SwaggerConfigProperties swaggerConfigProperties;

    @Autowired
    private SwaggerManagerRegisterFeign swaggerManagerRegisterFeign;

    @ApiOperation("注册到Api管理服务")
    @PostMapping(value = "/swagger/v2/client", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void registerToApiManageServer() {

        swaggerManagerRegisterFeign.register(swaggerConfigProperties);
    }

    @ApiOperation("暴露Remote Token Services接口，如果其它服务需要验证Token，则需要远程调用授权服务暴露的验证Token的API接口")
    @RequestMapping(value = "/user/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }
}
