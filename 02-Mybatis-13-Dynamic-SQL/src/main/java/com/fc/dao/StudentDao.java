package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
   List<Student> findAll();
   List<Student> findByKeyword(@Param("name") String name,@Param("info") String info);
   List<Student> findByStudent(Student student);
   List<Student> findByStudentOnTrim(Student student);
   int update(Student student);
   int updateOnTrim(Student student);
   int deleteMore(Integer... ids);
}
