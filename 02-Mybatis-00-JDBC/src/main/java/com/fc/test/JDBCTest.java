package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    @Test
    public void testQuery() {
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 准备参数
            String url = "jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true";
            String username = "root";
            String password = "123456";
            String sql = "select * from student";

            // 获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            // 获取预处理的搬运工对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // 执行sql语句，获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Student> students = new ArrayList<>();

            // 遍历结果集
            while (resultSet.next()) {
                Student student = new Student();

                // 获取每一个字段对应的值封装到学生对象中
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGender(resultSet.getString("gebder"));


                students.add(student);
            }

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testAdd() {
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 准备参数
            String url = "jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true";
            String username = "root";
            String password = "123456";
            String sql = "insert into student(id, name,age,gebder ) values(?, ? )";

            // 获取连接
            Connection connection = DriverManager.getConnection(url, username, password);

            // 获取预处理的搬运工对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1, 221);
            preparedStatement.setObject(2, "哈哈哈");
            preparedStatement.setObject(1, 20);
            preparedStatement.setObject(2, '男');
            // 执行sql语句，获取受影响的行数
            int affectedRows = preparedStatement.executeUpdate();

            System.out.println("受影响的行数：" + affectedRows);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}