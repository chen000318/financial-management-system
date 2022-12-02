package com.jr.biz.impl;

import com.jr.biz.IEnterpriseBiz;
import com.jr.dao.impl.EnterpriseDaoImpl;
import com.jr.entry.Enterprise;

import java.util.List;

public class EnterpriseBizImpl implements IEnterpriseBiz {

    /**
     * 准备一个EnterpriseDaoImpl实例对象
     */
    EnterpriseDaoImpl enterpriseDao = new EnterpriseDaoImpl();

    /**
     * 通过id获取企业信息
     * */
    @Override
    public Enterprise getEnterpriseInfo(int id) {
        return enterpriseDao.queryByid(id);
    }

    /**
     *获取所有企业名称
     * */
    @Override
    public List<Enterprise> getAllEnterpriseNames() {

        return enterpriseDao.queryAllEnterpriseNames();
    }
}
