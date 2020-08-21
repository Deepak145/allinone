package com.my.app.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.app.user.models.Instructor;

public interface InstructorDao extends JpaRepository<Instructor, Integer>{

}
