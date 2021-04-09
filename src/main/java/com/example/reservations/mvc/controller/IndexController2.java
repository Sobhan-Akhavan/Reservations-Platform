package com.example.reservations.mvc.controller;

import com.example.reservations.mvc.model.PlanFlight;
import com.example.reservations.mvc.model.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(value = "/index-controller2")
public class IndexController2 extends HttpServlet {

    protected void service (HttpServletRequest request, HttpServletResponse response) throws IOException {

        PlanFlight planFlight = (PlanFlight) request.getAttribute("Key_PlanFlight");
        request.removeAttribute("Key_PlanFlight");
        HttpSession httpSession = request.getSession();
        Ticket ticket;
        Random random = new Random();
        int result = random.nextInt(3) + 1;
        switch (result) {
            case 1: {
                ticket = new FirstClass(planFlight);
                httpSession.setAttribute("Key_Ticket", ticket);
                break;
            }
            case 2: {
                ticket = new Economic(planFlight);
                httpSession.setAttribute("Key_Ticket", ticket);
                break;
            }
            case 3: {
                ticket = new Charter(planFlight);
                httpSession.setAttribute("Key_Ticket", ticket);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + result);
        }
        response.sendRedirect("ticket_info.jsp");
    }
}