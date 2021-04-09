package com.example.reservations.mvc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login-panel-controller")
public class LoginPanelController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession httpSession = request.getSession();

        String actions;

        if (request.getParameter("button1") != null) {
            actions = "payment";
        }
        else if (request.getParameter("button2") != null) {
            actions = "change";
        }
        else if (request.getParameter("button3") != null) {
            actions = "remove";
        }
        else {
            actions = "logout";
        }
        switch (actions) {
            case "payment": {
                httpSession.setAttribute("Sign", "payment");
                response.sendRedirect("ticket-controller");
                break;
            }
            case "change": {
                httpSession.setAttribute("Sign", "change");
                response.sendRedirect("ticket-controller");
                break;
            }
            case "remove": {
                httpSession.setAttribute("Sign", "remove");
                response.sendRedirect("ticket-controller");
                break;
            }
            case "logout": {
                httpSession.removeAttribute("username");
                response.sendRedirect("login.jsp");
                break;
            }
        }
    }
}