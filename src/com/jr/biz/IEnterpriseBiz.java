package com.jr.biz;

import com.jr.entry.Enterprise;

import java.util.List;

public interface IEnterpriseBiz {
    /*
    * 通过id获取企业信息
    * */
    public Enterprise getEnterpriseInfo(int id);

    /*
    *获取所有企业名称
    * */
    public List<Enterprise> getAllEnterpriseNames();
}
