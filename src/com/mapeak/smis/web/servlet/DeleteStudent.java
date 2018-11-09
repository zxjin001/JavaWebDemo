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

@WebServlet("/student/delete")
public class DeleteStudent extends HttpServlet {
	private IStudentDao dao = null;
	
	public void init() throws ServletException {
		dao = new StudentDaoImpl();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1�������������
		String id = req.getParameter("id");
		//2������ҵ�񷽷�
		dao.delete(Long.valueOf(id));
		//�����ݴ洢�� request �У����ݵ� JSP
		//3�����ƽ�����ת
		resp.sendRedirect(getServletContext().getContextPath() + "/student/list");
	}
	
	protected void servie(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
//		//1�������������
//		String id = req.getParameter("id");
//		//2������ҵ�񷽷�
//		dao.delete(Long.valueOf(id));
//		//�����ݴ洢�� request �У����ݵ� JSP
//		//3�����ƽ�����ת
//		resp.sendRedirect(getServletContext().getContextPath() + "/student/list");
		
	}
}
