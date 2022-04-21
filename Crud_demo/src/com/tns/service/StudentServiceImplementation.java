package com.tns.service;

import com.tns.dao.StudentDao;
import com.tns.dao.StudentDaoImplementation;
import com.tns.entity.Student;

public class StudentServiceImplementation implements StudentService {

	private StudentDao dao;

	public StudentServiceImplementation() {
		dao = new StudentDaoImplementation();
	}

	@Override
	public void addStudent(Student student) {
		dao.beginTransaction();
		dao.addStudent(student);
		dao.commitTransaction();
	}

	@Override
	public void updateStudent(Student student) {
		dao.beginTransaction();
		dao.updateStudent(student);
		dao.commitTransaction();

	}

	@Override
	public void removeStudent(Student student) {
		dao.beginTransaction();
		dao.removeStudent(student);
		dao.commitTransaction();

	}

	@Override
	public Student findStudentById(int id) {
		// no need of transaction, as it's an read operation
		Student student = dao.getStudentById(id);
		return student;
	}

}
