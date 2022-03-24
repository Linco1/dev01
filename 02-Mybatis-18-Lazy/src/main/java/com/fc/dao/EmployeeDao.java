package com.fc.dao;

import com.fc.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findByDepartmentId(@Param("id") Integer id);
}
