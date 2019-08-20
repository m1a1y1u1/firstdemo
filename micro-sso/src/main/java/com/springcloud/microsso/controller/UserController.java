package com.springcloud.microsso.controller;

import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.domain.dto.UserQueryCondition;
import com.springcloud.microsso.service.UserService;
import io.ebean.PagedList;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/31 18:17 <br/>
 * @Author: 玄冥
 */
@RestController
@RequestMapping("/sso/user")
@Api("User Controller 用户控制器")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User findByName(String name) {
        return userService.findByName(name);
    }

    @PostMapping(value = "/paged-list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PagedList<User> pagedList(@RequestBody UserQueryCondition condition) {
        return userService.queryPagedList(condition);
    }

    @PostMapping(value = "/registry", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void registry(@RequestBody User user) {
        userService.registry(user);
    }

    @DeleteMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public int findUserById(@PathVariable Long id) {
        return userService.deleteByPrimaryKey(id);
    }
}
