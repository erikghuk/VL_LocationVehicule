package com.erik.servlet;

import com.erik.model.Controller;
import com.erik.model.DAOException;
import com.erik.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ReservingServlet")
public class ReservingServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        controller = new Controller();

    }

    private Controller controller;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession reservedCarSession = request.getSession();

        Vehicle vehicle = null;
        try {
            vehicle = controller.getRequestingCarFromParc(request);
            reservedCarSession.setAttribute("vehicle", vehicle);
        } catch (DAOException e) {
            request.setAttribute("message", e.getMessage());
            this.getServletContext().getRequestDispatcher("/reserving.jsp").forward(request, response);
        }
        if(vehicle == null) {
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        Integer days = (Integer) request.getSession().getAttribute("reservingDays");
        String startDate = (String) request.getSession().getAttribute("startDate");
        String endDate = (String) request.getSession().getAttribute("endDate");

        request.setAttribute("car", vehicle);
        request.setAttribute("days", days);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);

        this.getServletContext().getRequestDispatcher("/reserving.jsp").forward(request, response);
    }
}
