package com.greatlearning.springbootmvcapp.springbootmvcapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatlearning.springbootmvcapp.springbootmvcapplication.model.Student;
import com.greatlearning.springbootmvcapp.springbootmvcapplication.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		this.studentservice = studentservice;
	}

	@RequestMapping("/registration")
	public String register(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("student", student);
		return "registration-form";
	}
	

	@GetMapping("/studentinfo/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Student getStudentInfo(@PathVariable int id) {
		Student student = studentservice.getStudent(id);
		if (student == null) {
			throw new RuntimeException("Employee Not Found");
		} else {
			return student;
		}
	}

	@GetMapping("/studentsinfo")
	public String getAllStudentInfo(Model theModel) {
		List<Student> studentsList = studentservice.getStudents();
		theModel.addAttribute("students", studentsList);
		return "list-students";
	}

	@PostMapping("/savestudent")
	//@ResponseBody
	//@ResponseStatus(HttpStatus.CREATED)
	public String saveStudentInfo(@RequestParam("firstname") String first_name,
			@RequestParam("lastname") String last_name, @RequestParam("coursename") String course,
			@RequestParam("country") String country, Model theModel) {
		System.out.println("Entered the funtion saveStudentInfo()");
		Student student = Student.builder().firstname(first_name).lastname(last_name).coursename(course)
				.country(country).build();
		theModel.addAttribute("student", student);
		studentservice.saveStudent(student);
		return "create-notification";
	}

	@PostMapping("/updatestudent")
	//@ResponseBody
//	@ResponseStatus(HttpStatus.CREATED)
	public String updateStudentInfo(@RequestParam int id, @RequestParam("firstname") String first_name,
			@RequestParam("lastname") String last_name, @RequestParam("coursename") String course,
			@RequestParam("country") String country,Model theModel) {
		System.out.println("Entered the funtion updateStudentInfo()");
		Student student = studentservice.getStudent(id);
		student.setFirstname(first_name);
		student.setLastname(last_name);
		student.setCoursename(course);
		student.setCountry(country);
		studentservice.saveStudent(student);
		theModel.addAttribute("student", student);
		studentservice.saveStudent(student);
		return "create-notification";
	}

	@Transactional
	@RequestMapping("/deletestudent")
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public String deleteStudent(@RequestParam(value = "id") int id, Model theModel) {
		System.out.println("Entered the funtion deleteStudent()");
		Student student = studentservice.getStudent(id);
		if (student == null) {
			throw new RuntimeException("Student with student Id " + id + " does not exist");
		} else {
			studentservice.deleteById(student.getId());
			theModel.addAttribute("student", student);
			return "delete-notification";
		}

	}

	@GetMapping("/loadform")
	public String loadForm(@RequestParam("id") int id, Model theModel) {
		System.out.println("Entered the funtion loadForm()");
		Student student = studentservice.getStudent(id);
		theModel.addAttribute("student", student);
		return "updateForm";
	}

}
