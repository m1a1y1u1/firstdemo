package com.springcloud.microsso.domain.dto;

import com.springcloud.microcommon.domain.Pageable;
import lombok.Data;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: micro-parent <br/>
 * @Date: 2019/8/7 13:41 <br/>
 * @Author: 玄冥
 */
@Data
public class UserQueryCondition extends Pageable {
    private String name;
    private String nickName;
}
