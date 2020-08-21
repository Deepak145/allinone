package com.my.app.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.user.models.Instructor;

@RestController
public class InstructorController {

	@GetMapping(path="/instructor")
	public List<Instructor> getAllInstructor() {
		return null;
	}
	@GetMapping(path="/instructor/{id}")
	public Instructor getInstructorById(@PathVariable Integer id) {
		return null;
	}
}
