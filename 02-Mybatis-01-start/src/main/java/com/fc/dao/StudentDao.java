package com.fc.dao;

import com.fc.entity.Student;

public interface StudentDao {
    Student select();

    int add();


    Student findById(Integer id);
}