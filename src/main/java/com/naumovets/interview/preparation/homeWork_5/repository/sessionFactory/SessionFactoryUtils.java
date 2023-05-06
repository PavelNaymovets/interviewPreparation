package com.naumovets.interview.preparation.homeWork_5.repository.sessionFactory;

import org.hibernate.Session;

public interface SessionFactoryUtils {
    Session getSession();
    void shutdown();
}
