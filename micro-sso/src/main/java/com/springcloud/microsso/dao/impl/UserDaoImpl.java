package com.springcloud.microsso.dao.impl;

import com.springcloud.microcommon.dao.impl.BaseDaoImpl;
import com.springcloud.microsso.dao.UserDao;
import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.domain.query.QUser;
import org.springframework.stereotype.Repository;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/8/5 9:20 <br/>
 * @Author: 玄冥
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User,Long> implements UserDao{

    /**
     * 根据名称获取User对象
     *
     * @param username
     * @return
     */
    @Override
    public User findByName(String username) {
        return new QUser().username.eq(username).findOne();
    }
}
