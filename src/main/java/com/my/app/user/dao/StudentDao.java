package com.my.app.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.app.user.models.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{}
