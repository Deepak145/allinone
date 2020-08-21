package com.my.app.user.batch;

import org.springframework.batch.item.ItemProcessor;

import com.my.app.user.models.Student;

public class StudentBatchProcessor implements ItemProcessor<Student,Student>{

	@Override
	public Student process(Student item) throws Exception {
		return item;
	}
}
