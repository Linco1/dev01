package com.fc.entity;

public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gebder;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gebder;
    }

    public void setGender(String gender) {
        this.gebder = gender;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gebder + '\'' +
                '}';
    }
}
