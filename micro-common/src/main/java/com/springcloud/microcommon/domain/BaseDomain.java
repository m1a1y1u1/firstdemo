package com.springcloud.microcommon.domain;

import io.ebean.Model;
import io.ebean.annotation.*;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.Instant;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/25 14:02 <br/>
 * @Author: 玄冥
 */
@Data
@MappedSuperclass
public abstract class BaseDomain extends Model {
    @Id
    long id;

    @Version
    Long version;

    @WhenCreated
    Instant whenCreated;

    @WhenModified
    Instant whenModified;

    @WhoCreated
    String whoCreated;

    @WhoModified
    String whoModified;

    @SoftDelete
    boolean deleted;
}
