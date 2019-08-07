package com.springcloud.microsso.dao;

import com.springcloud.microcommon.dao.BaseDao;
import com.springcloud.microsso.domain.User;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/8/5 9:20 <br/>
 * @Author: 玄冥
 */
public interface UserDao extends BaseDao<User, Long> {
    /**
     * 根据名称获取User对象
     *
     * @param name
     * @return
     */
    User findByName(String name);
}
