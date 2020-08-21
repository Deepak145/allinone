package com.my.app.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.user.dao.InstructorDao;
import com.my.app.user.models.Instructor;

@Service
public class InstructorService {
	
	@Autowired InstructorDao instructorDao;
	
	public List<Instructor> getAllInstructor() {
		return instructorDao.findAll();
	}

	public Instructor getInstructorById(Integer id) {
		Optional<Instructor> instructorOpt = instructorDao.findById(id);
		if(instructorOpt.isPresent()) return instructorOpt.get();
		return null;
	}
}
