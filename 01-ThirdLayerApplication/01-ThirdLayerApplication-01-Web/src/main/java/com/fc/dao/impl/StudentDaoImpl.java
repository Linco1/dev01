package com.fc.dao.impl;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.DruidUtil;
import com.fc.vo.PageInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
     QueryRunner queryRunner = new QueryRunner();

     Connection connection = DruidUtil.getConnection();

    // 获取总数据量
    @Override
    public int getTotalCount() {


        String sql = "select * from student1";

        List<Student> list = null;

        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(Student.class));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        if (list == null) {
            return 0;
        }

        return list.size();
    }

    @Override
    public List<Student> getList(int start, int pageSize) {
        return null;
    }

    // 获取每页中的数据
    @Override
    public List<Student> getListByPage(int start, int pageSize) {
        String sql = "select * from student limit ?, ?";

        List<Student> list = null;

        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(Student.class), start, pageSize);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return list;
    }


}
