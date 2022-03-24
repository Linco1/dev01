package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
   List<Student> findAll();

   Student findById(@Param("id") Integer id);

   int insert(Student student);

   int delete(@Param("id")Integer id);

   int update(Student student);
   List<Student>  findByKeyword(@Param("keyword") String keyword);
   int getAutoIncrement(Student student);
}
