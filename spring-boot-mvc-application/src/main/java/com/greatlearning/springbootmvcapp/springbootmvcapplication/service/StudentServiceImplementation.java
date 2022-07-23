package com.greatlearning.springbootmvcapp.springbootmvcapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.Student;
import com.greatlearning.springbootmvcapp.springbootmvcapplication.repository.RepositoryDB;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private RepositoryDB repositoryDb;
//
//	private StudentServiceImplementation(RepositoryDB repositoryDb) {
//		repositoryDb = repositoryDb;
//	}

	@Override
	public Student getStudent(int id) {
		log.info("Inside StudentServiceImplementation Get() Method");
		// return repositoryDb.getStudent(id);
		return repositoryDb.getById(id);

	}

	@Override
	public Student saveStudent(Student s) {
		// (String firstname, String lastname, String course, String country) {
		log.info("Saved Information to the Database");

		// return repositoryDb.saveStudent(firstname, lastname, course, country) ;
		repositoryDb.save(s);

		return s;

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		// repositoryDb.deleteStudent(id);
		log.info("Deleted Information from the Database");

		repositoryDb.deleteById(id);
	}

	@Override
	public List<Student> getStudents() {
		// return repositoryDb.getAllStudents();
		log.info("Fetchin All Students Information from the Database");

		return repositoryDb.findAll();
	}

}
