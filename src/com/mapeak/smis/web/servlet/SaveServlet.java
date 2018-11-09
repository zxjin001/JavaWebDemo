package com.mapeak.smis.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mapeak.smis.dao.IStudentDao;
import com.mapeak.smis.dao.impl.StudentDaoImpl;
import com.mapeak.smis.domain.Student;

@WebServlet("/student/save")
public class SaveServlet extends HttpServlet {
private IStudentDao dao = null;
	
	public void init() throws ServletException {
		dao = new StudentDaoImpl();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//1、接收请求参数
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String id = req.getParameter("id");
		Student stu = new Student();
		stu.setName(name);
		stu.setAge(Integer.valueOf(age));
		//2、调用业务方法
		if (id != null && id.length() != 0) {
			stu.setId(Long.valueOf(id));
			dao.update(stu);
		} else {
		dao.save(stu);
		}
		//3、控制界面跳转
		resp.sendRedirect(getServletContext().getContextPath() + "/student/list");
	}

	protected void servie(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	}
}
