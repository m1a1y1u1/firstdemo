package com.springcloud.microsso.service;

import com.springcloud.microcommon.service.BaseService;
import com.springcloud.microsso.domain.User;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/24 18:06 <br/>
 * @Author: 玄冥
 */
public interface DemoService extends BaseService<User, Long> {
    User findByName(String name);
}
