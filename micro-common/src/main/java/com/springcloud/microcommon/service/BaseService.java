package com.springcloud.microcommon.service;

import com.springcloud.microcommon.domain.BaseDomain;
import io.ebean.ExpressionList;
import io.ebean.PagedList;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/26 17:43 <br/>
 * @Author: 玄冥
 */
public interface BaseService<T extends BaseDomain, K> {
    /**
     * 主键id查询
     *
     * @param key
     * @return
     */
    T findById(K key);

    /**
     * 实体保存方法
     *
     * @param entity
     */
    void save(T entity);

    /**
     * 实体更新方法
     *
     * @param entity
     */
    void update(T entity);

    /**
     * 按主键删除
     *
     * @param key
     * @return
     */
    int deleteByPrimaryKey(K key);
}
