package com.fc.controller;

import com.fc.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("annotation")
public class TestRestControllerAnnotationController {
    @RequestMapping("getUser")
    public User getUser(){
        return new User("易烊千玺","123456");
    }
    @RequestMapping("toIndex")
    public String toIndex(){
        return "/index.jsp";
    }
}
