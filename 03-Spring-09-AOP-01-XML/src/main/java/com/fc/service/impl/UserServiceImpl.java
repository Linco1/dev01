package com.fc.service.impl;

import com.fc.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加了一个新的用户：wk.me");
    }

    @Override
    public void update() {
        int num = 1/0;
        System.out.println("修改了用户的信息：ks.me");
    }
}
