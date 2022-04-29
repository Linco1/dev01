package com.fc.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class CustomEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        String[] profiles = {"jdbc.properties","student.yml"};
        for (String profile : profiles) {
            Resource resource = new ClassPathResource(profile);
            Properties properties;
            if (profile.contains("properties")){
                 properties = new Properties();
                 try{
                     properties.load(resource.getInputStream());
                 }catch (IOException e){
                     e.printStackTrace();
                 }
            }else{
                YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
                factoryBean.setResources(resource);
               properties = factoryBean.getObject();
            }
            PropertiesPropertySource propertySource = new PropertiesPropertySource(profile, properties);
            environment.getPropertySources().addLast(propertySource);
        }
    }
}
