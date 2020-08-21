package com.my.app.user.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.my.app.user.models.Student;

@Configuration
@EnableBatchProcessing
public class StudentBatchConfiguration {

	@Autowired private JobBuilderFactory jobFactory;
	
	@Autowired private StepBuilderFactory stepFactory;
	
	@Value("classpath:/student.csv") private Resource resource;
	
	@Bean
	public Job createJob() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {
		return jobFactory.get("STUDENT_JOB")
				  .incrementer(new RunIdIncrementer())
				  .start(step())
				  .build();
	}
	private Step step() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception {
		return stepFactory.get("STUDENT_STEP")
				   .<Student,Student>chunk(2)
				   .reader(read())
				   .processor(processor())
				   .writer(writer())
				   .build();
	}
	
	private ItemProcessor<Student, Student> processor() {
		return new StudentBatchProcessor();
	}
	public FlatFileItemReader<Student> read() 
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		DefaultLineMapper<Student> lineMapper = new DefaultLineMapper<>();
		
		reader.setResource(resource);
		reader.setLinesToSkip(1);
 
		String [] tokens = new String []{"NAME", "CITY", "STATE", "COUNTRY","PIN","YEAR"};
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames(tokens);
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(new RecordFieldSetMapper());
		reader.setLineMapper(lineMapper);
		return reader;
	}
	
	 @Bean
	 public ItemWriter<Student> writer() {
	      return new ConsoleItemWriter();
	}
}
