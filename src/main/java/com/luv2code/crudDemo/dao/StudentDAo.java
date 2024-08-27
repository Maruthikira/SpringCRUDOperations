package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAo {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastname);
    void  updateStudent(Student student);

    void deleteStudent(Integer id);
}
