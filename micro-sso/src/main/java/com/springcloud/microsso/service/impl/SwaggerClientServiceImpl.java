package com.springcloud.microsso.service.impl;

import com.springcloud.microcommon.service.impl.BaseServiceImpl;
import com.springcloud.microsso.dao.SwaggerClientDao;
import com.springcloud.microsso.domain.SwaggerClient;
import com.springcloud.microsso.domain.User;
import com.springcloud.microsso.domain.dto.SwaggerClientQC;
import com.springcloud.microsso.domain.query.QSwaggerClient;
import com.springcloud.microsso.service.SwaggerClientService;
import io.ebean.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2019 <br/>
 * @Desc: <br/>
 * @ProjectName: firstdemo <br/>
 * @Date: 2019/7/24 18:07 <br/>
 * @Author: 玄冥
 */
@Service
public class SwaggerClientServiceImpl extends BaseServiceImpl<User,Long> implements SwaggerClientService {

    private SwaggerClientDao swaggerClientDao;
    @Autowired
    public SwaggerClientServiceImpl(SwaggerClientDao swaggerClientDao) {
        super(swaggerClientDao);
        this.swaggerClientDao = swaggerClientDao;
    }

    @Override
    public void register(SwaggerClient client) {
        swaggerClientDao.save(client);
    }

    /**
     * 分页查询客户端
     *
     * @param qc
     * @return
     */
    @Override
    public PagedList<SwaggerClient> queryPagedList(SwaggerClientQC qc) {
        return new QSwaggerClient()
//                .description.like(String.format("%%%s%%", qc.getDescription()))
                .setFirstRow(qc.getPageSize() * (qc.getPageIndex() - 1))
                .setMaxRows(qc.getPageSize() * qc.getPageIndex())
                .findPagedList();
    }
}
