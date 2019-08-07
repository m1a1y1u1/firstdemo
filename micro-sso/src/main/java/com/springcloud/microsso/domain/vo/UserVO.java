package com.springcloud.microsso.domain.vo;

import com.springcloud.microcommon.enums.common.GenderTypeEnum;
import io.ebean.annotation.DbComment;
import lombok.Data;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: micro-parent <br/>
 * @Date: 2019/8/7 14:25 <br/>
 * @Author: 玄冥
 */
@Data
public class UserVO {
    @DbComment("用户名")
    private String name;
    @DbComment("昵称")
    private String nickName;
    @DbComment("年龄")
    private Integer ages;
    @DbComment("性别")
    private GenderTypeEnum gender;
}
