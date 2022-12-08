package com.example.studentproject;

import com.example.studentproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentProjectApplication implements CommandLineRunner {
    @Autowired
    private StudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(StudentProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentService.createDb();
        JPAUtil.checkData("select * from province");
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from student_subject");
        JPAUtil.checkData("select * from subject");

    }
}
