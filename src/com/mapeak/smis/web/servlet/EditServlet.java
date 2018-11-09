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

@WebServlet("/student/edit")
public class EditServlet extends HttpServlet {

	private IStudentDao dao = null;

	public void init() throws ServletException {
		dao = new StudentDaoImpl();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// 1、接收请求参数
		String id = req.getParameter("id");
		// 2、调用业务方法
		if (id != null && id.length() != 0) {
			Student stu = dao.get(Long.valueOf(id));
			req.setAttribute("student", stu);
		}
		// 3、控制界面跳转
		req.getRequestDispatcher("/WEB-INF/views/student_edit.jsp").forward(req, resp);
	}

	protected void servie(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1、接收请求参数
		// 2、调用业务方法
		// 3、控制界面跳转
		// req.getRequestDispatcher("/WEB-INF/views/student_edit.jsp").forward(req,
		// resp);
	}
}
