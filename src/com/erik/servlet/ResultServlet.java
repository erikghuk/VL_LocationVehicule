package com.erik.servlet;

import com.erik.model.Controller;
import com.erik.model.DAOException;
import com.erik.model.Parc;

import javax.servlet.http.HttpSession;

public class ResultServlet extends javax.servlet.http.HttpServlet {


    private Controller controller;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        HttpSession requestSession = request.getSession();
        controller = new Controller();
        try {
            controller.getSearchResult(request);
        } catch (DAOException e) {
            request.setAttribute("message", e.getMessage());
            this.getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        }
        Parc parc = controller.getRequestingCars();
        if(parc == null) {
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }


        requestSession.setAttribute("parcOfRequestingCars", controller.getRequestingCars());
        requestSession.setAttribute("reservingDays", controller.getReservingDays());
        requestSession.setAttribute("startDate", controller.getStartDate());
        requestSession.setAttribute("endDate", controller.getEndDate());
        requestSession.setMaxInactiveInterval(700);

        request.setAttribute("availableCars", controller.getRequestingCars());
        request.setAttribute("days", controller.getReservingDays());
        this.getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        HttpSession requestSession = request.getSession();
        controller = new Controller();
        try {
            controller.getSearchResult(request);
        } catch (DAOException e) {
            requestSession.setAttribute("message", e.getMessage());
            this.getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        }
        Parc parc = controller.getRequestingCars();
        if(parc == null) {
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
