package com.fc.config;

import com.fc.entity.Car;
import com.fc.entity.Cat;
import com.fc.entity.Person;
import com.fc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Configuration(proxyBeanMethods = false)
@Import(Cat.class)
public class TestConfig {
    @Bean({"car","car1","car2"})
    public Car getCar(){
        return new Car("奥迪","黑色");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化。。");
    }
    @Bean("person")
    public Person getPerson(Car car){
        return new Person("拉拉", getCar());
    }

    @Bean
    public User getUser(){
        return new User();
    }
    public String test(){
        System.out.println("测试方法被执行");
        return "测试";
    }
}
