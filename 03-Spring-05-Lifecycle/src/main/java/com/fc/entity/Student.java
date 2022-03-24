package com.fc.entity;

public class Student {
    private Integer id;
    private String name;
    private Byte age;
    public Student(){
        System.out.println("无参构造被执行~~~");
    }
    public void eat(){
        System.out.println("就是喜欢吃");
    }
    public void sleep(){
        System.out.println("吃完就睡");
    }
}
