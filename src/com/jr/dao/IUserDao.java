package com.jr.dao;

import com.jr.entry.User;

/**
 * userDao
 */
public interface IUserDao {
    /**
     * 通过用户账号和用户密码查询指定用户
     */
    public User queryByAccountAndPassword(User user);


}
