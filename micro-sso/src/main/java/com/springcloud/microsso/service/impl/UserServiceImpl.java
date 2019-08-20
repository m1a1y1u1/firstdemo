package com.springcloud.microsso.service.impl;

import com.springcloud.microcommon.exception.BusinessException;
import com.springcloud.microcommon.service.impl.BaseServiceImpl;
import com.springcloud.microsso.dao.UserDao;
import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.domain.dto.UserQueryCondition;
import com.springcloud.microsso.domain.query.QUser;
import com.springcloud.microsso.service.UserService;
import io.ebean.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/24 18:07 <br/>
 * @Author: 玄冥
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
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
        return new QUser().username.like(String.format("%%%s%%", condition.getName()))
                .nickName.like(String.format("%%%s%%", condition.getNickName()))
                .setFirstRow(condition.getPageSize() * (condition.getPageIndex() - 1))
                .setMaxRows(condition.getPageSize() * condition.getPageIndex())
                .findPagedList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new QUser().username.eq(username).findOne();
    }
    @Override
    public User registry(User user) {
        User origin = new QUser().username.eq(user.getUsername()).findOne();
        if(origin != null){
            throw new BusinessException("该用户已注册");
        }
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return user;
    }
}
