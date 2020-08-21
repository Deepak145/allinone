package com.my.app.user.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.my.app.user.models.Student;

public class ConsoleItemWriter implements ItemWriter<Student> {

	
	@Override
	public void write(List<? extends Student> items) throws Exception {
		System.out.println(items);
	}

}
