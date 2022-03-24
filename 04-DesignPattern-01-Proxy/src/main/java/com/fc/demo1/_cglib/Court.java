package com.fc.demo1._cglib;


import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class Court {
    @Test
    public void test(){
        Parties parties = new Parties();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(parties.getClass());
        enhancer.setCallback(new LawOffice());
        Parties proxy = (Parties) enhancer.create();
        proxy.submit();
        proxy.defend();

    }
}
