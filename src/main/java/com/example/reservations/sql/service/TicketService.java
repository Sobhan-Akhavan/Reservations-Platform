package com.example.reservations.sql.service;

import com.example.reservations.mvc.entity.TicketInfo;
import com.example.reservations.sql.dao.TicketDao;
import com.example.reservations.sql.dao.sfInjector;

import org.hibernate.Session;

import java.util.List;

public class TicketService {

    private TicketDao ticketDao;
    private sfInjector Injector;
    private Session session;

    public TicketService() {
        this.ticketDao = new TicketDao();
        this.Injector = new sfInjector();
        this.session = Injector.getSession();
    }

    public TicketInfo Add(TicketInfo ticket) throws Exception {
        session.getTransaction().begin();
        try {
            ticketDao.setSession(session);
            ticketDao.Insert(ticket);
            session.getTransaction().commit();
            return ticket;
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do not Inserted");
        }
    }

    public TicketInfo Edit(TicketInfo ticket) throws Exception {
        session.getTransaction().begin();
        try {
            ticketDao.setSession(session);
            ticketDao.Update(ticket);
            session.getTransaction().commit();
            return ticket;
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do not Update");
        }
    }

    public void Remove(TicketInfo ticket) throws Exception {
        session.getTransaction().begin();
        try {
            ticketDao.setSession(session);
            ticketDao.Delete(ticket);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do no Delete");
        }
    }

    public TicketInfo getTicket(int id) throws Exception {
        session.getTransaction().begin();
        try {
            ticketDao.setSession(session);
            TicketInfo result = new TicketInfo();
            result = ticketDao.getEntity(id);
            session.getTransaction().commit();
            return result;
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do no get Ticket");
        }
    }

    public List<TicketInfo> getAll() throws Exception {
        session.getTransaction().begin();
        try {
            ticketDao.setSession(session);
            session.getTransaction().commit();
            return ticketDao.selectAll();
        }
        catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception("Error! Do not Select All");
        }
    }
}
