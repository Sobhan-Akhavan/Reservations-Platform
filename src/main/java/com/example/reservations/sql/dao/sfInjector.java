package com.example.reservations.sql.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class sfInjector {

    private SessionFactory sessionFactory;
    private Session session;

    public sfInjector() {}

    public Session getSession () {
        if (session == null) {
            this.sessionFactory = new Configuration().configure().buildSessionFactory();
            this.session = sessionFactory.openSession();
        }
        return session;
    }
}
