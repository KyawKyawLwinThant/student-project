package com.example.studentproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student_subject")
@Getter
@Setter
public class StudentSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_subject_id")
    private Integer id;
    private int marks;
    @JoinColumn(name = "sub_id")
    @ManyToOne
    private Subject subject;
    @JoinColumn(name = "stu_id")
    @ManyToOne
    private Student student;
}
