package com.example.studentproject.dao;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StudentDto {

    private String studentName;
    private String provinceName;
    private String subjectName;
    private int marks;

    public StudentDto(String studentName, String provinceName, String subjectName, int marks) {
        this.studentName = studentName;
        this.provinceName = provinceName;
        this.subjectName = subjectName;
        this.marks = marks;
    }
}
