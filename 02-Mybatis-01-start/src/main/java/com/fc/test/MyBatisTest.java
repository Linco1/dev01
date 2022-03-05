package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    @Test
    public void testDao() {
        try {
            // 读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取数据库连接
            SqlSession session = factory.openSession();

            // 获取接口的实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.select();

            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddOnDao() {
        try {
            // 读取配置
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取连接
            SqlSession session = factory.openSession();

            // 获取接口的实现类对象
            StudentDao studentDao = session.getMapper(StudentDao.class);

            // 调用接口中的方法
            int affectedRows = studentDao.add();

            // 提交增删改操作
            session.commit();

            // 关闭连接
            session.close();

            System.out.println("受影响的行数：" + affectedRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById() {
        // 读取配置
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 获取工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            // 获取连接
            SqlSession session = factory.openSession();

            // 获取接口的实现类
            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = studentDao.findById(3);

            System.out.println(student);

            // 提交
            session.commit();

            // 关闭连接
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}