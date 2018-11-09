package com.mapeak.smis.dao;

import java.util.List;

import com.mapeak.smis.domain.Student;

//��װ Student ����� CRUD ����
public interface IStudentDao {
	//�������
	void save(Student stu);
	
	//ɾ������
	void delete(Long id);
	
	//���²���
	void update(Student stu);
	
	//��ȡָ�� id ��ѧ������
	Student get(Long id);
	
	//��ѯ����ѧ������
	List<Student> listAll();
}
