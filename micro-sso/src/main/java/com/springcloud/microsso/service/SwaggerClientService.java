package com.springcloud.microsso.service;

import com.springcloud.microcommon.service.BaseService;
import com.springcloud.microsso.domain.SwaggerClient;
import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.domain.dto.SwaggerClientQC;
import io.ebean.PagedList;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/24 18:06 <br/>
 * @Author: 玄冥
 */
public interface SwaggerClientService extends BaseService<User, Long> {
    /**
     * 客户端注册接口
     * @param client
     */
    void register(SwaggerClient client);

    /**
     * 分页查询客户端
     * @param qc
     * @return
     */
    PagedList<SwaggerClient> queryPagedList(SwaggerClientQC qc);
}
