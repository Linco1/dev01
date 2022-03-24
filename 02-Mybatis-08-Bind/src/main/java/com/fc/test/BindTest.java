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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BindTest {
@Test
    public void test(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = studentDao.findByIdAndName(1, "易烊千玺");
        session.commit();
        session.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @Test
    public void testFindByNameAndAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.findByNameAndAge("古力娜扎", 30);
            System.out.println(students);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByIdAndGender(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id",1);
            map.put("gender","男");
            Student student = studentDao.findByIdAndGender(map);
            System.out.println(student);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
