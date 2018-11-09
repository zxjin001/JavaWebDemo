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

//��ѯ�����е�ѧ����Ϣ
@WebServlet("/student/list")
public class ListStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStudentDao dao;
	public void init() throws ServletException {
		dao = new StudentDaoImpl();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1�������������
		//2������ҵ�񷽷�
		List<Student> list = dao.listAll();
		//�����ݴ洢�� request �У����ݵ� JSP
		//�� JSP ��ʹ�� ${StuList}��ȡ����
		req.setAttribute("StuList", list);
		//3�����ƽ�����ת
		req.getRequestDispatcher("/WEB-INF/views/student_list.jsp").forward(req, resp);
	}
}
