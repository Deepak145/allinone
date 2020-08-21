package com.my.app.user.batch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.boot.context.properties.bind.BindException;

import com.my.app.user.models.Address;
import com.my.app.user.models.Student;

public class RecordFieldSetMapper implements FieldSetMapper<Student> {
 
	Logger log = LoggerFactory.getLogger(RecordFieldSetMapper.class);
	
    public Student mapFieldSet(FieldSet fieldSet) throws BindException {
    	log.info("fieldSet data" +fieldSet.toString());
        Student student = new Student();
        Address address = new Address();
       // student.setId(new Integer(fieldSet.readString("ID")));
        student.setName(fieldSet.readString("NAME"));
       // address.setAddress_id(fieldSet.readInt("ADDRESS_ID"));
        address.setCity(fieldSet.readString("CITY"));
        address.setState(fieldSet.readString("STATE"));
        address.setCountry(fieldSet.readString("COUNTRY"));
        address.setPin(new Long(fieldSet.readString("PIN")));
        student.setAddress(address);
        student.setYear(fieldSet.readString("YEAR"));
        log.info("student obejct " + student);
        return student;
    }
}