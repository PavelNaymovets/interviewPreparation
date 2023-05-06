package com.naumovets.interview.preparation.homeWork_5.repository.dao.student;

import com.naumovets.interview.preparation.homeWork_5.model.Student;

import java.util.List;

public interface StudentDao {
    Student findById(int id);
    List<Student> findAll();
    void deleteById(int id);
    void saveOrUpdate(Student student);
}
