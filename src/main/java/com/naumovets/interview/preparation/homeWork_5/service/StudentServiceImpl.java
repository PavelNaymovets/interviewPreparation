package com.naumovets.interview.preparation.homeWork_5.service;

import com.naumovets.interview.preparation.homeWork_5.model.Student;
import com.naumovets.interview.preparation.homeWork_5.repository.dao.student.StudentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;


    @Override
    public Student findStudentById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public void deleteStudentById(int id) {
        studentDao.deleteById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveOrUpdate(student);
    }

    @Override
    public void updateNameStudent(int id, String name) {
        Student student = studentDao.findById(id);
        student.setName(name);
        studentDao.saveOrUpdate(student);
    }

    @Override
    public void updateMarkStudent(int id, int mark) {
        Student student = studentDao.findById(id);
        student.setMark(mark);
        studentDao.saveOrUpdate(student);
    }
}
