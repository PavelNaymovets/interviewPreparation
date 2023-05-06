package com.naumovets.interview.preparation.homeWork_5.service;

import com.naumovets.interview.preparation.homeWork_5.model.Student;

import java.util.List;

public interface StudentService {
    Student findStudentById(int id);
    List<Student> findAllStudents();
    void deleteStudentById(int id);
    void saveStudent(Student student);
    void updateNameStudent(int id, String name);
    void updateMarkStudent(int id, int mark);
}
