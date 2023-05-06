package com.naumovets.interview.preparation.homeWork_5;

import com.naumovets.interview.preparation.homeWork_5.appConfig.AppConfig;
import com.naumovets.interview.preparation.homeWork_5.model.Student;
import com.naumovets.interview.preparation.homeWork_5.repository.sessionFactory.SessionFactoryUtils;
import com.naumovets.interview.preparation.homeWork_5.repository.sessionFactory.SessionFactoryUtilsImpl;
import com.naumovets.interview.preparation.homeWork_5.service.StudentService;
import com.naumovets.interview.preparation.homeWork_5.service.StudentServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class HomeWorkApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SessionFactoryUtils sessionFactory = context.getBean(SessionFactoryUtilsImpl.class);
        StudentService studentService = context.getBean(StudentServiceImpl.class);

        Student student = studentService.findStudentById(1);
        System.out.println(student);

        List<Student> students = studentService.findAllStudents();
        System.out.println(students);

        studentService.deleteStudentById(1);
        List<Student> studentsAfterRemoving = studentService.findAllStudents();
        System.out.println(studentsAfterRemoving);

        Student student1 = new Student();
        student1.setName("New Student");
        student1.setMark(5);
        studentService.saveStudent(student1);
        List<Student> studentsAfterSaving = studentService.findAllStudents();
        System.out.println(studentsAfterSaving);

        studentService.updateNameStudent(3, "New name");
        Student studentsAfterNameUpdating = studentService.findStudentById(3);
        System.out.println(studentsAfterNameUpdating);

        studentService.updateMarkStudent(3, 4);
        Student studentAfterMarkUpdating = studentService.findStudentById(3);
        System.out.println(studentAfterMarkUpdating);

        sessionFactory.shutdown();
    }
}
