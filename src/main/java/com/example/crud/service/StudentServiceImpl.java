package com.example.crud.service;

import com.example.crud.exception.StudentException;
import com.example.crud.model.Student;
import com.example.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new StudentException("Student", "Id", id));
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student studentEx = studentRepository.findById(id).orElseThrow(() ->
                new StudentException("Student", "Id", id));
        studentEx.setFirstName(student.getFirstName());
        studentEx.setLastName(student.getLastName());
        studentEx.setEmail(student.getEmail());
        studentRepository.save(studentEx);
        return studentEx;
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.findById(id).orElseThrow(()->
                new StudentException("Student", "ID", id));
        studentRepository.deleteById(id);
    }
}
