package com.my.app.user.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.my.app.user.models.Student;
import com.my.app.user.service.StudentService;

public class ConsoleItemWriter implements ItemWriter<Student> {
	Logger  log = LoggerFactory.getLogger(ConsoleItemWriter.class);
	
	@Autowired StudentService studentService;
	
	@Override
	public void write(List<? extends Student> items) throws Exception {
		log.info("Student List to persist " +items);
		studentService.SaveStudents(items);
		log.info("data persisted");
	}
}
