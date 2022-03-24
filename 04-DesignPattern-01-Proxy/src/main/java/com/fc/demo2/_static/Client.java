package com.fc.demo2._static;

import org.junit.Test;

public class Client {
    @Test
    public void test(){
        GamePlayer player = new GamePlayer();
        GamePlayProxy proxy = new GamePlayProxy(player);
        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
