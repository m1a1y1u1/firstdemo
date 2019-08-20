package com.springcloud.microsso.domain;

import com.springcloud.microcommon.domain.BaseDomain;
import io.ebean.annotation.DbComment;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

@Entity
@Data
@DbComment("用户角色表")
public class Role extends BaseDomain implements GrantedAuthority {
    @DbComment("用户角色描述")
    private String description;
    @DbComment("用户角色唯一编码")
    private String code;
    @Override
    public String getAuthority() {
        return code;
    }
}