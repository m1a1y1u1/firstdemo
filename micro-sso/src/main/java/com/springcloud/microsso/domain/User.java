package com.springcloud.microsso.domain;

import com.springcloud.microcommon.domain.BaseDomain;
import com.springcloud.microcommon.enums.common.GenderTypeEnum;
import io.ebean.annotation.DbComment;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/25 14:02 <br/>
 * @Author: 玄冥
 */
@Data
@Entity
@DbComment("基础用户表")
public class User extends BaseDomain {
    @DbComment("用户名")
    private String name;
    @DbComment("昵称")
    private String nickName;
    @DbComment("密码")
    private String password;
    @DbComment("年龄")
    private Integer ages;
    @DbComment("性别")
    private GenderTypeEnum gender;
}
