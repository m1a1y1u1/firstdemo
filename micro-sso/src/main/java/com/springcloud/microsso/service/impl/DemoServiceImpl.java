package com.springcloud.microsso.service.impl;

import com.springcloud.microcommon.dao.BaseDao;
import com.springcloud.microcommon.service.impl.BaseServiceImpl;
import com.springcloud.microsso.dao.UserDao;
import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.domain.dto.UserQueryCondition;
import com.springcloud.microsso.domain.query.QUser;
import com.springcloud.microsso.domain.vo.UserVO;
import com.springcloud.microsso.service.DemoService;
import io.ebean.DtoQuery;
import io.ebean.PagedList;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/24 18:07 <br/>
 * @Author: 玄冥
 */
@Service
public class DemoServiceImpl extends BaseServiceImpl<User,Long> implements DemoService {
    private UserDao userDao;

    @Autowired
    public DemoServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    /**
     * 条件查询用户分页列表（单表通用）
     *
     * @param condition
     * @return
     */
    @Override
    public PagedList<User> queryPagedList(UserQueryCondition condition) {
        return new QUser().name.like(String.format("%%s%", condition.getName()))
                .nickName.like(String.format("%%s%", condition.getNickName()))
                .setFirstRow(condition.getPageSize() * (condition.getPageIndex() - 1))
                .setMaxRows(condition.getPageSize() * condition.getPageIndex())
                .findPagedList();
    }
}
