package com.jr.dao;

import com.jr.entry.Enterprise;

import java.util.List;

public interface IEnterpriseDao {
    /*
    * 根据企业id查询企业信息
    * */
    public Enterprise queryByid(int id);

    /*
     *查询所有企业名称
     * */
    public List<Enterprise> queryAllEnterpriseNames();
}
