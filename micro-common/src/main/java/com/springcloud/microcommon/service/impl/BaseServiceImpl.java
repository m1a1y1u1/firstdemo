package com.springcloud.microcommon.service.impl;

import com.springcloud.microcommon.dao.BaseDao;
import com.springcloud.microcommon.domain.BaseDomain;
import com.springcloud.microcommon.service.BaseService;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/31 18:02 <br/>
 * @Author: 玄冥
 */
public class BaseServiceImpl<T extends BaseDomain, K> implements BaseService<T, K> {

    private BaseDao<T, K> baseDao;

    public BaseServiceImpl(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public T findById(K key) {
        return baseDao.findById(key);
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public int deleteByPrimaryKey(K key) {
        return baseDao.deleteByPrimaryKey(key);
    }

}
