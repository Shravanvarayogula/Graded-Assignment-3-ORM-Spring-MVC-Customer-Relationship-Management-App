package com.greatlearning.springbootmvcapp.springbootmvcapplication.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.Student;

@Component
public interface StudentService {

	public Student getStudent(int id);

	//public Student saveStudent(String firstname, String lastname, String course, String country);

	public void deleteById(int id);

	public List<Student> getStudents();

	Student saveStudent(Student s);

}