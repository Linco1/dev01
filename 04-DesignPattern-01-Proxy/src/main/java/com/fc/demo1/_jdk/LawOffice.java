package com.fc.demo1._jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LawOffice implements InvocationHandler {
    private final Object target;

    public LawOffice(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("案情进展：" +method.getName());
        Object invoke = method.invoke(target, args);
        if (method.getName().equals("defend")){

        }
        return invoke;
    }
}
