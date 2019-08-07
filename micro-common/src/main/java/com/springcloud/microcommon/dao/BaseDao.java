package com.springcloud.microcommon.dao;

import com.springcloud.microcommon.domain.BaseDomain;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: micro-parent <br/>
 * @Date: 2019/8/7 11:44 <br/>
 * @Author: 玄冥
 */
public interface BaseDao<T extends BaseDomain, K> {
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
