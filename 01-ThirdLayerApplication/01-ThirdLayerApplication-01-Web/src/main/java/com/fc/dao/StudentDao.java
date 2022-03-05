package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
    int getTotalCount();
    List<Student> getList(int start, int pageSize);


    // 获取每页中的数据
    List<Student> getListByPage(int start, int pageSize);
}
