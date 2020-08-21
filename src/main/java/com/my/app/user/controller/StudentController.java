package com.my.app.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.user.models.Student;

@RestController
public class StudentController {

	@GetMapping(path="/student")
	public List<Student> getAllStudent(){
		return null;
	}
	
	@GetMapping(path="/student/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return null;
	}
	
}
