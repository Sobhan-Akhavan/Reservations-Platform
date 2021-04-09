package com.example.reservations.mvc.controller;


import com.example.reservations.sql.service.LoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login-controller")
public class LoginController extends HttpServlet {

    private LoginService service;

    public void init() {
        this.service = new LoginService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession httpSession = request.getSession();

        String actions;

        if (request.getParameter("flag") != null) {
            actions = "login";
        }
        else {
            actions = "signup";
        }

        switch (actions) {
            case "login": {
                String username = request.getParameter("uname");
                String password = request.getParameter("pass");

                if (service.check(username, password)) {
                    httpSession.setAttribute("username", username);
                    response.sendRedirect("login_panel.jsp");
                }
                else {
                    httpSession.setAttribute("Notifications", "error login");
                    response.sendRedirect("login.jsp");
                }
                break;
            }
            case "signup": {
                response.sendRedirect("signup.jsp");
                break;
            }
        }
    }
}
