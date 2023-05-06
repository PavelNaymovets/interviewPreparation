package com.naumovets.interview.preparation.homeWork_5.repository.sessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtilsImpl implements SessionFactoryUtils {
    private SessionFactory sessionFactory;

    public SessionFactoryUtilsImpl() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    public Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
