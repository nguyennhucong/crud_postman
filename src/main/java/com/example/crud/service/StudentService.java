package com.example.crud.service;


import com.example.crud.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    public Student findById(Long id);
    Student saveStudent(Student student);
    Student updateStudent(Student student, Long id);
    void deleteById(Long id);
}
