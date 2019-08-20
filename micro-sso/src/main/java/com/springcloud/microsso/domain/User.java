package com.springcloud.microsso.domain;

import com.springcloud.microcommon.domain.BaseDomain;
import com.springcloud.microcommon.enums.common.GenderTypeEnum;
import io.ebean.annotation.DbComment;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.List;

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
public class User extends BaseDomain implements UserDetails {

    @DbComment("用户名")
    private String username;
    @DbComment("昵称")
    private String nickName;
    @DbComment("密码")
    private String password;
    @DbComment("年龄")
    private Integer ages;
    @DbComment("性别")
    private GenderTypeEnum gender;
    @DbComment("邮箱")
    private String email;
    @DbComment("用户角色")
    private List<Role> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
