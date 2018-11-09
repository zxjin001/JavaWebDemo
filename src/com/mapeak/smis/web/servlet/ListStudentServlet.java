package com.mapeak.smis.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mapeak.smis.dao.IStudentDao;
import com.mapeak.smis.dao.impl.StudentDaoImpl;
import com.mapeak.smis.domain.Student;

//查询出所有的学生信息
@WebServlet("/student/list")
public class ListStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStudentDao dao;
	public void init() throws ServletException {
		dao = new StudentDaoImpl();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、接收请求参数
		//2、调用业务方法
		List<Student> list = dao.listAll();
		//把数据存储到 request 中，传递到 JSP
		//在 JSP 中使用 ${StuList}获取数据
		req.setAttribute("StuList", list);
		//3、控制界面跳转
		req.getRequestDispatcher("/WEB-INF/views/student_list.jsp").forward(req, resp);
	}
}
