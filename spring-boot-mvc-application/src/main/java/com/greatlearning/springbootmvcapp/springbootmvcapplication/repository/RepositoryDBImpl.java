package com.greatlearning.springbootmvcapp.springbootmvcapplication.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.Student;

public class RepositoryDBImpl  {
/*
	@Autowired
	private EntityManager entitymanager;

	public RepositoryDBImpl(EntityManager theentitymanager) {
		entitymanager = theentitymanager;
	}

	public Student getStudent(int id) {
		// Get current Hibernate session from JPA API
		Session currentsession = entitymanager.unwrap(Session.class);
		Student student = currentsession.get(Student.class, id);
		return student;
	}

	public Student saveStudent(String firstname, String lastname, String course, String country) {
		Session currentsession = entitymanager.unwrap(Session.class);
		Student s = Student.builder().firstname(firstname).lastname(lastname).coursename(course).country(country)
				.build();
		currentsession.save(s);
		return s;
	}

	public void deleteStudent(int id) {
		Session currentsession = entitymanager.unwrap(Session.class);
		Query q = currentsession.createQuery("delete from Student where id = :id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

	public List<Student> getAllStudents() {
		Session currentsession = entitymanager.unwrap(Session.class);
		Query<Student> q = currentsession.createQuery("from Student", Student.class);
		List<Student> student = q.getResultList();
		return student;
	}
	*/
}
