package com.springcloud.microcommon.domain;

import lombok.Data;

import java.util.List;

/**
 * @copyright: <br> Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @desc: <br>${}<br/>
 * @projectName: <br> micro-parent <br/>
 * @date: <br> 2019/8/12 9:15 <br/>
 * @author: 马雨
 */
@Data
public class PagedList<T> {
    public PagedList(io.ebean.PagedList<T> pagedList) {
        this.pageSize = pagedList.getPageSize();
        this.pageIndex = pagedList.getPageIndex();
        this.list = pagedList.getList();
        this.totalCount = pagedList.getTotalCount();
        this.totalPageCount = pagedList.getTotalPageCount();
        this.hasNext = pagedList.hasNext();
        this.hasPrev = pagedList.hasPrev();
        this.displayXtoYofZ = pagedList.getDisplayXtoYofZ("到","总");
    }

    private int pageSize;
    private int pageIndex;
    private List<T> list;
    private int totalCount;
    private int totalPageCount;
    private boolean hasNext;
    private boolean hasPrev;
    private String displayXtoYofZ;
}
