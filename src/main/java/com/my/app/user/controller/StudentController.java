package com.my.app.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.user.models.Student;
import com.my.app.user.service.StudentService;

@RestController
public class StudentController {

	@Autowired StudentService service; 
	
	@GetMapping(path="/student")
	public List<Student> getAllStudent(){
		return null;
	}
	
	@GetMapping(path="/student/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return null;
	}
	
	@GetMapping(path="/update")
	public void updateStudent() {
		service.SaveStudents(new ArrayList());
	}
	
}
