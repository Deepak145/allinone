package com.my.app.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.user.dao.StudentDao;
import com.my.app.user.models.Address;
import com.my.app.user.models.Student;

@Service
public class StudentService {

	@Autowired StudentDao studentDao;
	
	public List<Student> getAllStudent(){
		return studentDao.findAll();
	}
	
	public Student getStudentById(Integer id) {
		Optional<Student> student=  studentDao.findById(id);
		if(student.isPresent()) return student.get();
		return null;
	}
	
	public void SaveStudents(List<? extends Student> students) {
		/*
		 * List<Student> myStudents = new ArrayList<>(); Student s1 = new Student();
		 * Address a1 = new Address(); // s1.setId(1); s1.setName("Deepa");
		 * //a1.setAddress_id(101); a1.setCity("Jabalpur"); a1.setCountry("India");
		 * a1.setPin(202020); s1.setAddress(a1); s1.setYear("2020"); myStudents.add(s1);
		 */
		studentDao.saveAll(students);
	}
}
