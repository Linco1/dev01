package com.fc.dao;

import com.fc.entity.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentDao {
    Department findByDepartmentId(@Param("id") Integer id);
}
