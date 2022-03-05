package com.fc.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class JDBCTest {
    @Test
    public void testAdd(){
    try {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/rx2001?useSSL=false&useUnicode=true";
        String username = "root";
        String password = "123456";
        String sql = "insert into student1(name,age,gender,info) values (?,?,?,?)";

        Connection connection = DriverManager.getConnection(url,username,password);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int affectedRows = preparedStatement.executeUpdate();

        System.out.println("受影响的行数：" +affectedRows );
    } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
