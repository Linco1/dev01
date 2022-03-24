package com.fc.demo2._cglib;

import com.fc.demo2._jdk.GamePlay;

public class GamePlayer implements GamePlay {
    @Override
    public void login() {
        System.out.println("ks.me TiMi~~");
    }

    @Override
    public void killBoss() {
        System.out.println("ks.me 打怪");
    }

    @Override
    public void upgrade() {
        System.out.println("ks.me 升级");
    }
}
