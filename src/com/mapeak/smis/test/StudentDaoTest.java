package com.mapeak.smis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mapeak.smis.dao.IStudentDao;
import com.mapeak.smis.dao.impl.StudentDaoImpl;
import com.mapeak.smis.domain.Student;

public class StudentDaoTest {

	private IStudentDao dao = new StudentDaoImpl();

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		Student stu = dao.get(5L);
		System.out.println(stu);
	}

	@Test
	public void testListAll() {
		List<Student> stuList = dao.listAll();
		if (!stuList.isEmpty()) {
			for (Student stu : stuList) {
				System.out.println(stu);
			}
		}

	}

}
