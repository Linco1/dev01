package com.fc.config;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

public class YamlConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        ClassPathResource resource = new ClassPathResource("student.yml");
        factoryBean.setResources(resource);
        Properties properties = factoryBean.getObject();
        configurer.setProperties(properties);
        return configurer;
    }
}
