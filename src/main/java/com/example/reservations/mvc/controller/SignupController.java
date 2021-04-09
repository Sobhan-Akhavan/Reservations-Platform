package com.example.reservations.mvc.controller;

import com.example.reservations.mvc.entity.UserSignup;
import com.example.reservations.sql.service.SignupService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/signup-controller")
public class SignupController extends HttpServlet {

    private UserSignup user;
    private SignupService signup;

    public void init() {
        this.user = new UserSignup();
        this.signup = new SignupService();
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession httpSession = request.getSession();

        user.setFirstName(request.getParameter("first_name"));
        user.setLastName(request.getParameter("last_name"));
        user.setUsername(request.getParameter("uname"));
        user.setPassword(request.getParameter("pass"));

        try {
            signup.Add(user);
            httpSession.setAttribute("Notifications", "signup");
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}