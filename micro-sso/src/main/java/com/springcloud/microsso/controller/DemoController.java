package com.springcloud.microsso.controller;

import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.domain.dto.UserQueryCondition;
import com.springcloud.microsso.service.DemoService;
import io.ebean.PagedList;
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
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User insert(@PathVariable Long id) {
        return demoService.findById(id);
    }

    @GetMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User insert(String name) {
        return demoService.findByName(name);
    }

    @PostMapping(value = "/user/paged-list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public PagedList<User> pagedList(@RequestBody UserQueryCondition condition) {
        return demoService.queryPagedList(condition);
    }

    @PostMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void findUserById(@RequestBody User user) {
        demoService.save(user);
    }

    @DeleteMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public int findUserById(@PathVariable Long id) {
        return demoService.deleteByPrimaryKey(id);
    }
}
