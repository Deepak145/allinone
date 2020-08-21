package com.my.app.user.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.boot.context.properties.bind.BindException;

import com.my.app.user.models.Student;

public class RecordFieldSetMapper implements FieldSetMapper<Student> {
 
    public Student mapFieldSet(FieldSet fieldSet) throws BindException {
        Student student = new Student();
        student.setId(new Integer(fieldSet.readString("ID")));
        student.setName(fieldSet.readString("NAME"));
        student.getAddress().setCity(fieldSet.readString("CITY"));
        student.getAddress().setState(fieldSet.readString("STATE"));
        student.getAddress().setCountry(fieldSet.readString("COUNTRY"));
        student.getAddress().setPin(new Long(fieldSet.readString("PIN")));
        student.setYear(fieldSet.readString("YEAR"));
        return student;
    }
}