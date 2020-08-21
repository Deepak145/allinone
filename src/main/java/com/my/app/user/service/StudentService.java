package com.my.app.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.my.app.user.models.Student;

@Service
public class StudentService {

	public List<Student> getAllStudent(){
		return null;
	}
	
	public Student getStudentById(@PathVariable Integer id) {
		return null;
	}
}
