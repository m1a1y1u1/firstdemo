package com.springcloud.microsso.service;

import com.springcloud.microcommon.service.BaseService;
import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.domain.dto.UserQueryCondition;
import io.ebean.PagedList;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/24 18:06 <br/>
 * @Author: 玄冥
 */
public interface DemoService extends BaseService<User, Long> {
    /**
     * 根据用户名称查询用户
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 条件查询用户分页列表（单表通用）
     * @param condition
     * @return
     */
    PagedList<User> queryPagedList(UserQueryCondition condition);
}
