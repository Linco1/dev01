package com.fc.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;

    public Object[] getUsername() {
        return new Object[0];
    }
}
