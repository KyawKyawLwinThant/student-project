package com.example.studentproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name = "findStudentByName",
        query = "select s from Student s where s.name =?1")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;
    private String name;
    private int age;
    private String school;
    @JoinColumn(name = "p_id")
    @ManyToOne
    private Province province;
    @OneToMany(mappedBy = "student",
    cascade = CascadeType.PERSIST)
    private List<StudentSubject> studentSubjects=
            new ArrayList<>();

    public Student(){

    }

    public void addStudentSubject(StudentSubject studentSubject){
        studentSubject.setStudent(this);
        studentSubjects.add(studentSubject);
    }



    public Student(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                '}';
    }
}
