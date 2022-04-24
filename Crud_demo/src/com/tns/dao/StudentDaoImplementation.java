package com.tns.dao;

import javax.persistence.EntityManager;

import com.tns.entity.Student;

public class StudentDaoImplementation implements StudentDao {
	private EntityManager entityManager;

	public StudentDaoImplementation() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Student getStudentById(int id) {
		// for retrieval find()
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public void addStudent(Student student) {
		// for insertion persist();
		entityManager.persist(student);
	}

	@Override
	public void removeStudent(Student student) {
		// for delete operation
		entityManager.remove(student);
	}

	@Override
	public void updateStudent(Student student) {
		// for update operation
		entityManager.merge(student);
	}

	// we have to do use this methods for every operation except retrieval

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
}
