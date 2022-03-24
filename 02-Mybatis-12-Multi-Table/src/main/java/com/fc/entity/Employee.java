package com.fc.entity;

import lombok.Data;

@Data
public class Employee {
    private  int id;
    private String name;
    private Department department;
}
