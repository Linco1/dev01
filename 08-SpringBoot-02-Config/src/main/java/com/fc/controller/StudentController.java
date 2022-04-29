package com.fc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @Value("${student.name}")
    private String name;
@RequestMapping("test")
    public String testYml(){
        return name;
    }
}
