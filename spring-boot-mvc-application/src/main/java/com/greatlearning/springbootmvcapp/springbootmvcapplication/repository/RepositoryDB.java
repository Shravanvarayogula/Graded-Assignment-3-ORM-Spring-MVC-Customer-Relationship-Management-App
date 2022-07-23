package com.greatlearning.springbootmvcapp.springbootmvcapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.Student;


@Repository
public interface RepositoryDB extends JpaRepository<Student, Integer>{
//	public Student getStudent(int id) ;
//
//	public Student saveStudent(String firstname, String lastname, String course, String country) ;
//	
//	public void deleteStudent(int id) ;
//
//	public List<Student> getAllStudents();

}
