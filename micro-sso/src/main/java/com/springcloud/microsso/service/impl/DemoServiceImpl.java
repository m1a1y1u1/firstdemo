package com.springcloud.microsso.service.impl;
import com.springcloud.microcommon.service.impl.BaseServiceImpl;
import com.springcloud.microsso.dao.UserDao;
import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.Name;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/24 18:07 <br/>
 * @Author: 玄冥
 */
@Service
public class DemoServiceImpl extends BaseServiceImpl<User,Long> implements DemoService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
