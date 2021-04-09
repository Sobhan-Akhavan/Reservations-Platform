package com.example.reservations.mvc.controller;

import com.example.reservations.mvc.model.PlanFlight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/index-controller")
public class IndexController extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PlanFlight planFlight;
        int n = Integer.parseInt(request.getParameter("num"));
        switch (n) {
            case 1: {
                planFlight = new PlanFlight("Mashhad", "Tehran");
                break;
            }
            case 2: {
                planFlight = new PlanFlight("Mashhad", "Tabriz");
                break;
            }
            case 3: {
                planFlight = new PlanFlight("Mashhad", "Shiraz");
                break;
            }
            case 4: {
                planFlight = new PlanFlight("Mashhad", "Isfahan");
                break;
            }
            case 5: {
                planFlight = new PlanFlight("Mashhad", "Yazd");
                break;
            }
            case 6: {
                planFlight = new PlanFlight("Mashhad", "Kish");
                break;
            }
            case 7: {
                planFlight = new PlanFlight("Mashhad", "Rasht");
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
        request.setAttribute("Key_PlanFlight", planFlight);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index-controller2");
        requestDispatcher.forward(request, response);
    }
}