package com.fc.config;

import com.fc.entity.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("car")
    @ConditionalOnBean(Person.class)
    @ConditionalOnMissingBean(Bike.class)
    public Car getCar(){
        return new Car();
    }
    //@Bean("wife")
    public Wife getWife(){
        return new Wife();
    }
    @Bean("son")
    @ConditionalOnBean(Wife.class)
    public Son getSon(){
        return new Son();
    }
    @Bean("girlFriend")
    @ConditionalOnMissingBean(Wife.class)
    public GirlFriend getGirlFriend(){
        return new GirlFriend();
    }
}
