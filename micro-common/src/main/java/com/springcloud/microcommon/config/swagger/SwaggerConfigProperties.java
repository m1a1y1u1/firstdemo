package com.springcloud.microcommon.config.swagger;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@ConfigurationProperties(prefix = "sop.swagger")
@Component
@Data
public class SwaggerConfigProperties implements Serializable {
    /**
     * 将当前服务注册到swagger管理平台的接口
     */
    private String registerManageApi;

    /**
     * 是否开启Swagger
     */
    private boolean enable = false;
    /**
     * 要扫描的包
     */
    private String packageScan;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 版本信息
     */
    private String apiVersion;
    /**
     * 工程代号
     */
    private String project;
    /**
     * 父工程代号
     */
    private String projectParent;
    /**
     * 启动环境
     */
    @Value("${spring.profiles.active}")
    private String profile;
}