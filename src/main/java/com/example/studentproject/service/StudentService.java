package com.example.studentproject.service;

import com.example.studentproject.dao.*;
import com.example.studentproject.entity.Province;
import com.example.studentproject.entity.Student;
import com.example.studentproject.entity.StudentSubject;
import com.example.studentproject.entity.Subject;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private StudentSubjectDao studentSubjectDao;
    @Autowired
    private StudentDao studentDao;

    public Student findStudentByName(String name){
        return studentDao.findStudentByName(name)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<ProvinceDto> listProvinceInfo(){
        return studentSubjectDao.findProvinceInfo();
    }

    public StudentDto findStudentDtoByMaxMarksInSubject(String subjectName){
        return studentSubjectDao.findStudentInfoMaxMarks(subjectName)
                .orElseThrow(EntityExistsException::new);
    }

    public Iterable<StudentDto> listStudentInfo(){

        return studentSubjectDao.findStudentInfo();
    }



    @Transactional
    public void createDb(){
        Province p1=new Province();
        p1.setName("Sule");

        Province p2=new Province();
        p2.setName("NO");

        Student s1=new Student("Thaw Thaw",23,"Latha");
        Student s2=new Student("John Doe",22,"ISM");
        Student s3=new Student("John William",23,"PISM");
        Student s4=new Student("Thomas Hardy",23,"ISY");


        Subject subject1=new Subject("Java","6 months",2000);
        Subject subject2=new Subject("Python","3 months",1500);
        Subject subject3=new Subject("Groovy","3 months",1000);

        //mapping
        p1.addStudent(s1);
        p1.addStudent(s2);
        p2.addStudent(s3);
        p2.addStudent(s4);

        StudentSubject studentSubject1=new StudentSubject();
        studentSubject1.setMarks(95);



        StudentSubject studentSubject2=new StudentSubject();
        studentSubject2.setMarks(70);
        StudentSubject studentSubjectManage2=studentSubjectDao.save(studentSubject2);

        StudentSubject studentSubject3=new StudentSubject();
        studentSubject3.setMarks(90);

        StudentSubject studentSubject4=new StudentSubject();
        studentSubject4.setMarks(75);

        //student 1 got 95 marks in subject1
        s1.addStudentSubject(studentSubjectDao.save(studentSubject1));
        subject1.addStudentSubject(studentSubjectDao.save(studentSubject1));
        //student 1 got 70 marks in subject2
        s1.addStudentSubject(studentSubjectManage2);
        subject2.addStudentSubject(studentSubjectManage2);
        //student 2 got 90 marks in subject 1
        s2.addStudentSubject(studentSubjectDao.save(studentSubject3));
        subject1.addStudentSubject(studentSubjectDao.save(studentSubject3));

        s3.addStudentSubject(studentSubjectDao.save(studentSubject4));
        subject3.addStudentSubject(studentSubjectDao.save(studentSubject4));

        provinceDao.save(p1);
        provinceDao.save(p2);
        subjectDao.save(subject1);
        subjectDao.save(subject2);
        subjectDao.save(subject3);

    }

}


