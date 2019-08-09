package com.springcloud.microsso.controller;

import com.springcloud.microsso.domain.SwaggerClient;
import com.springcloud.microsso.domain.dto.SwaggerClientQC;
import com.springcloud.microsso.service.SwaggerClientService;
import io.ebean.PagedList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @copyright: <br> Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @desc: <br>${}<br/>
 * @projectName: <br> micro-parent <br/>
 * @date: <br> 2019/8/9 19:00 <br/>
 * @author: 马雨
 */
@RestController
@RequestMapping("/v2/client")
@Api("Swagger2 控制台 客户端控制器")
public class SwaggerClientController {

    @Autowired
    private SwaggerClientService swaggerClientService;

    @ApiOperation("客户端注册接口")
    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void register(@RequestBody SwaggerClient client, HttpServletRequest request) {
        client.setCallBackHost(request.getRemoteHost()+ ":" + request.getServerPort() + "/v2/api-docs");
        swaggerClientService.register(client);
    }

    @ApiOperation("获取工程分页列表")
    @GetMapping(value = "/paged-list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PagedList<SwaggerClient> pagedList(SwaggerClientQC qc) {
        return swaggerClientService.queryPagedList(qc);
    }

}
