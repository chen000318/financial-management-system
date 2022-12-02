package com.jr.biz.impl;

import com.jr.biz.IInstitutyBiz;
import com.jr.dao.impl.InstitutyDaoImpl;
import com.jr.entry.Instituty;

import java.util.List;

public class InstitutyBizImpl implements IInstitutyBiz {
    /**
     *获取所有金融机构名称
     * */
    @Override
    public List<Instituty> getAllNames() {
        InstitutyDaoImpl institutyDao = new InstitutyDaoImpl();
        return institutyDao.queryAllNames();
    }
}
