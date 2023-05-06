package com.naumovets.interview.preparation.homeWork_5.repository.dao.student;

import com.naumovets.interview.preparation.homeWork_5.model.Student;
import com.naumovets.interview.preparation.homeWork_5.repository.sessionFactory.SessionFactoryUtils;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {
    private final SessionFactoryUtils sessionFactory;

    @Override
    public Student findById(int id) {
        try (Session session = sessionFactory.getSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();

            return student;
        }
    }

    @Override
    public List<Student> findAll() {
        try (Session session = sessionFactory.getSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("SELECT s FROM Student s", Student.class).getResultList();
            session.getTransaction().commit();

            return students;
        }
    }

    @Override
    public void deleteById(int id) {
        try (Session session = sessionFactory.getSession()) {
            session.beginTransaction();
            session.remove(findById(id));
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveOrUpdate(Student student) {
        try (Session session = sessionFactory.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }
}
