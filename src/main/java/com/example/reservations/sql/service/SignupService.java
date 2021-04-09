package com.example.reservations.sql.service;

import com.example.reservations.mvc.entity.UserSignup;
import com.example.reservations.sql.dao.SignupDao;
import com.example.reservations.sql.dao.sfInjector;
import org.hibernate.Session;

import java.util.List;

public class SignupService {
    private SignupDao signupDao;
    private sfInjector Injector;
    private Session session;

    public SignupService() {
        this.signupDao = new SignupDao();
        this.Injector = new sfInjector();
        this.session = Injector.getSession();
    }

    public UserSignup Add(UserSignup userSignup) throws Exception {
        session.getTransaction().begin();
        try {
            signupDao.setSession(session);
            signupDao.Insert(userSignup);
            session.getTransaction().commit();
            return userSignup;
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do not Inserted");
        }
    }

    public UserSignup Edit(UserSignup userSignup) throws Exception {
        session.getTransaction().begin();
        try {
            signupDao.setSession(session);
            session.update(userSignup);
            session.getTransaction().commit();
            return userSignup;
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do not Update");
        }
    }

    public void Remove(UserSignup userSignup) throws Exception {
        session.getTransaction().begin();
        try {
            signupDao.setSession(session);
            signupDao.Delete(userSignup);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do no Delete");
        }
    }

    public UserSignup getTicket(int id) throws Exception {
        session.getTransaction().begin();
        try {
            signupDao.setSession(session);
            UserSignup result = new UserSignup();
            result = signupDao.getEntity(id);
            session.getTransaction().commit();
            return result;
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do no get Ticket");
        }
    }

    public List<UserSignup> getAll() throws Exception {
        session.getTransaction().begin();
        try {
            signupDao.setSession(session);
            session.getTransaction().commit();
            return signupDao.selectAll();
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do not Select All");
        }
    }
}
