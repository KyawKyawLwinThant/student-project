package com.example.studentproject.dao;

import com.example.studentproject.entity.StudentSubject;
import org.springframework.data.repository.CrudRepository;

public interface StudentSubjectDao extends CrudRepository<StudentSubject,Integer> {
}
