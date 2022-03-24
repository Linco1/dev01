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

public class CacheTest {
    @Test
    public void test(){
        try {
            InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session1 = factory.openSession();
            SqlSession session2 = factory.openSession();
            StudentDao studentDao1 = session1.getMapper(StudentDao.class);
            StudentDao studentDao2 = session2.getMapper(StudentDao.class);
            Student student1 = studentDao1.findById(1);
            Student student2 = studentDao2.findById(1);
            System.out.println(student1==student2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testTwo(){

        try {
            InputStream reader = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);

            System.out.println("第一次查询");
            studentDao.findById(8);

            session.commit();

            System.out.println("第二次查询");
            studentDao.findById(8);

            Student student = new Student();
            student.setId(8);
            student.setInfo("大魔王");

            studentDao.update(student);
            session.commit();

            System.out.println("第三次查询");
            studentDao.findById(8);

            session.close();

            SqlSession session2 = factory.openSession();

            StudentDao studentDao2 = session2.getMapper(StudentDao.class);

            System.out.println("第四次查询");
            studentDao2.findById(8);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



