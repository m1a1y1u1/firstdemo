package com.springcloud.microcommon.dao.impl;

import com.springcloud.microcommon.dao.BaseDao;
import com.springcloud.microcommon.domain.BaseDomain;
import io.ebean.Ebean;

import java.lang.reflect.ParameterizedType;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: micro-parent <br/>
 * @Date: 2019/8/7 11:46 <br/>
 * @Author: 玄冥
 */
public class BaseDaoImpl<T extends BaseDomain, K> implements BaseDao<T, K> {
    private Class<T> clazz;

    public BaseDaoImpl() {
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findById(K key) {
        return Ebean.find(clazz, key);
    }

    @Override
    public void save(T entity) {
        Ebean.save(entity);
    }

    @Override
    public void update(T entity) {
        Ebean.update(entity);
    }

    @Override
    public int deleteByPrimaryKey(K key) {
        return Ebean.delete(clazz, key);
    }
}
