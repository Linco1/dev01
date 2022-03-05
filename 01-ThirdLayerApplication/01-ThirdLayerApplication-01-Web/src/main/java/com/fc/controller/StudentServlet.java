package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.fc.service.impl.StudentServiceImpl;
import com.fc.vo.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/page")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("pageNo");


        int pageNo = 1;

        if (param != null) {
            pageNo = Integer.parseInt(param);
        }

        // 规定好每页显示多少条数据
        int pageSize = 5;



        PageInfo<Student> pageInfo = studentService.getPageInfo(pageNo, pageSize);

        req.setAttribute("pageInfo", pageInfo);

        req.getRequestDispatcher("query.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
