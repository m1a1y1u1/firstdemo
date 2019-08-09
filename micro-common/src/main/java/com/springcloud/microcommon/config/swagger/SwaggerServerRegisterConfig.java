package com.springcloud.microcommon.config.swagger;

import com.springcloud.microcommon.config.httpclient.HttpAPIService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.util.Map;

/**
 * @copyright: <br> Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @desc: <br>${}<br/>
 * @projectName: <br> micro-parent <br/>
 * @date: <br> 2019/8/9 17:40 <br/>
 * @author: 马雨
 */
@Configuration
@Log
public class SwaggerServerRegisterConfig implements ApplicationRunner {

    @Value("${server.port}")
    private String port;
    @Autowired
    private SwaggerConfigProperties properties;
    @Autowired
    private HttpAPIService httpAPIService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String localhost = InetAddress.getLocalHost().getHostAddress();
        log.info(String.format("swagger api 地址：%s", "http://" + localhost + ":" + port + "/v2/api-docs"));
        log.info("注册当前工程到Swagger api文档管理服务..");
        // 获取上传者信息，历史版本保留
        Map<String, Object> authorInfo = BeanMap.create(properties);
        httpAPIService.doPost(properties.getRegisterManageApi(), authorInfo);
    }
}
