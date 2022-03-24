package com.fc.service;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoOracleImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoOracleImpl();
    @Override
    public void useJDBC() {
        userDao.useJDBC();

    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
