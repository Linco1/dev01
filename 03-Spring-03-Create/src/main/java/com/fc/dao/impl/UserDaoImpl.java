package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("sqlSession调用方法，添加了一个用户...");
    }
    public UserDaoImpl(){

    }
    public UserDaoImpl(String sqlSession){

    }
}
