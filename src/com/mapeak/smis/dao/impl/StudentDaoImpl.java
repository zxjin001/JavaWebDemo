package com.mapeak.smis.dao.impl;

import java.util.List;

import com.mapeak.smis.dao.IStudentDao;
import com.mapeak.smis.domain.Student;
import com.mapeak.smis.handler.impl.BeanHandler;
import com.mapeak.smis.handler.impl.BeanListHandler;
import com.mapeak.smis.util.JdbcTemplate;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public List<Student> listAll() {
		return JdbcTemplate.query("SELECT * FROM t_student", new BeanListHandler<>(Student.class));
	}

	@Override
	public Student get(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = ?;";
		Student stu = JdbcTemplate.query(sql
				, new BeanHandler<>(Student.class), id);
		return stu;
	}

	@Override
	public void save(Student stu) {
		String sql = "INSERT INTO t_student (name, age) VALUES (?, ?)";
		JdbcTemplate.update(sql, stu.getName(), stu.getAge());
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_student WHERE id = ?;";
		JdbcTemplate.update(sql, id);
	}

	@Override
	public void update(Student stu) {
		String sql = "UPDATE t_student SET name=?, age=? WHERE id=?;";
		JdbcTemplate.update(sql, stu.getName(), stu.getAge(), stu.getId());
	}


}
