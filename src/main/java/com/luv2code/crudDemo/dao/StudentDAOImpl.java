package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements  StudentDAo{
      //define field for entity manager

    private EntityManager entityManager;
    //inject entity manager using constructor
     @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implements save method

    @Override
    @Transactional
    public void save(Student student) {
         entityManager.persist(student);

    }

    @Override
    public Student findById(Integer id) {
        Student student = entityManager.find(Student.class,id);
        return student;
    }

    @Override
    public List<Student> findAll() {
         //create the query
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student order by  lastName desc", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastname) {
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);
        theQuery.setParameter("theData",theLastname);

        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
         entityManager.merge(student);

    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
         Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }
}
