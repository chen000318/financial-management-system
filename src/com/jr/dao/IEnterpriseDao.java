package com.jr.dao;

import com.jr.entry.Enterprise;

import java.util.List;

public interface IEnterpriseDao {
    /*
    * 根据用户id查询企业信息
    * */
    public Enterprise queryByUid(int uid);

    /*
     *查询所有企业信息
     * */
    public List<Enterprise> queryAllEnterpriseNames();

    /**
     * 通过企业id查询企业信息
     */
    public Enterprise queryEnterpriseInfoByid(int id);
}
