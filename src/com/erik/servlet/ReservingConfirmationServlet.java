package com.erik.servlet;

import com.erik.model.Client;
import com.erik.model.Controller;
import com.erik.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ReservingConfirmationServlet")
public class ReservingConfirmationServlet extends HttpServlet {
    private Controller controller;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession reservedCarSession = request.getSession();
        controller = new Controller();

        Vehicle vehicle = (Vehicle) reservedCarSession.getAttribute("vehicle");
        Client client = controller.getRegisteredClient(request, vehicle);
        request.setAttribute("car", vehicle);
        if(client != null) {
            request.setAttribute("client", client);
        }
        this.getServletContext().getRequestDispatcher("/confirm.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
