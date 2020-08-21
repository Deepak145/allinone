package com.my.app.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.my.app.user.models.Instructor;

@Service
public class InstructorService {
	
	public List<Instructor> getAllInstructor() {
		return null;
	}

	public Instructor getInstructorById(@PathVariable Integer id) {
		return null;
	}
}
