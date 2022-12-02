package com.jr.biz.impl;

import com.jr.biz.IUserBiz;
import com.jr.dao.impl.UserDaoImpl;
import com.jr.entry.User;

public class UserBizImpl implements IUserBiz {
    UserDaoImpl userDao =new UserDaoImpl();
    /**
     * 登录功能
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.queryByAccountAndPassword(user);
    }
}
