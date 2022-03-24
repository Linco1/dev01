package com.fc.entity;

import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
public class Subject {
    private Integer id;
    private String name;
    private List<Student> students;
}
