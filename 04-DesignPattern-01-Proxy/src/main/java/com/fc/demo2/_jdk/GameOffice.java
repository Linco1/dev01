package com.fc.demo2._jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GameOffice implements InvocationHandler {
    private final Object object;

    public GameOffice(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("login")){
            System.out.println("小伙子正在输入账号密码");
        }
        Object invoke = method.invoke(object, args);
        if (method.getName().equals("upgrade")){
            System.out.println("增加了100点攻击力，1000生命值");
        }
        return invoke;
    }
}
