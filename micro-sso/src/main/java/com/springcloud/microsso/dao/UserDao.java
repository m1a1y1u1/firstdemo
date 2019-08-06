package com.springcloud.microsso.dao;

import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.domain.query.QUser;
import io.ebean.Ebean;
import io.ebean.Query;
import org.springframework.stereotype.Repository;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/8/5 9:20 <br/>
 * @Author: 玄冥
 */
public interface UserDao {
    /**
     * 根据名称获取User对象
     * @param name
     * @return
     */
    User findByName(String name);
}
