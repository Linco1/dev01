package com.fc.demo1._jdk;

import com.fc.demo1._cglib.Parties;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class Court {
    @Test
    public void test(){
        Parties parties = new Parties();
        LawOffice handler = new LawOffice(parties);
        Lawsuit proxy =(Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(),parties.getClass().getInterfaces(),handler);
        proxy.submit();
        proxy.defend();
    }
}
