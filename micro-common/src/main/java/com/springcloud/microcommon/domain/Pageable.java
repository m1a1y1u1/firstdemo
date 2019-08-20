package com.springcloud.microcommon.domain;

import com.springcloud.microcommon.enums.common.QuerySortTypeEnum;
import lombok.Data;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: 分页通用条件<br />
 * @ProjectName: micro-parent <br/>
 * @Date: 2019/8/7 11:33 <br/>
 * @Author: 玄冥
 */
@Data
public class Pageable {
    private int pageIndex = 1;
    private int pageSize = 20;
    private String sortField = "id";
    private QuerySortTypeEnum sortType = QuerySortTypeEnum.DESC;
}
