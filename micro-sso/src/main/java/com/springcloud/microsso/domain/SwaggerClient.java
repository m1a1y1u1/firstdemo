package com.springcloud.microsso.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.springcloud.microcommon.domain.BaseDomain;
import io.ebean.annotation.DbComment;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @copyright: <br> Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @desc: <br>${}<br/>
 * @projectName: <br> micro-parent <br/>
 * @date: <br> 2019/8/9 19:03 <br/>
 * @author: 马雨
 */
@Entity
@Data
@DbComment("Swagger2 client 注册信息实体类")
public class SwaggerClient extends BaseDomain {
    /**
     * 将当前服务注册到swagger管理平台的接口
     */
    @DbComment("将当前服务注册到swagger管理平台的接口")
    private String registerManageApi;
    /**
     * 标题
     */
    @DbComment("工程标题")
    private String title;
    /**
     * 描述
     */
    @DbComment("工程描述")
    private String description;
    /**
     * 版本信息
     */
    @DbComment("api doc 版本")
    private String apiVersion;
    /**
     * 启动环境
     */
    @DbComment("api doc 版本")
    private String profile;

    @DbComment("api doc json 拉取地址")
    private String callBackHost;
}
