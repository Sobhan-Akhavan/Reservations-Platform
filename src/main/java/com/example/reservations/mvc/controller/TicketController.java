package com.example.reservations.mvc.controller;

import com.example.reservations.mvc.entity.TicketInfo;
import com.example.reservations.mvc.entity.UserSignup;
import com.example.reservations.mvc.model.Ticket;
import com.example.reservations.sql.service.TicketService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/ticket-controller")
public class TicketController extends HttpServlet {

    private TicketInfo info;
    private TicketService service;

    public void init() {
        this.info = new TicketInfo();
        this.service = new TicketService();
    }

    protected void service (HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession httpSession = request.getSession();

        String action = (String) httpSession.getAttribute("Sign");
        request.removeAttribute("Sign");
        Ticket ticket = (Ticket) httpSession.getAttribute("Key_Ticket");
        request.removeAttribute("Key_Ticket");

        switch (action) {
            case "payment":
                info.setFrom(ticket.From());
                info.setTo(ticket.To());
                info.setPrice(ticket.Price());
                info.setTime(ticket.Time());
                try {
                    service.Add(info);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                httpSession.setAttribute("Flag", "add");
                response.sendRedirect("login_panel.jsp");
                break;
            case "change":
                httpSession.setAttribute("Flag", "update");
                response.sendRedirect("index.jsp");
                break;
            case "remove":
                httpSession.invalidate();
                try {
                    service.Remove(info);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response.sendRedirect("index.jsp");
                break;
        }
    }
}
