package com.erik.model;

import javax.servlet.http.HttpServletRequest;

public class SearchingForm {
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private String email;

    private String type;
    private String reservingDate;
    private String returningDate;
    private String dateRange;


    private String id;

    void getSearchFormParams(HttpServletRequest request) {
        type = request.getParameter("car_type");
        dateRange = request.getParameter("dateRange");
    }

    void getReservingFormParams(HttpServletRequest request) {
        id = request.getParameter("id");
    }

    void getLastReservingForm(HttpServletRequest request) {
        clientName = request.getParameter("client_name");
        clientSurname = request.getParameter("client_surname");
        clientAddress = request.getParameter("client_address");
        reservingDate = request.getParameter("client_startDate");
        returningDate = request.getParameter("client_endDate");
        email = request.getParameter("client_email");
    }

    public String getType() {
        return type;
    }

    String getReservingDate() {
        return reservingDate;
    }

    void setReservingDate(String reservingDate) {
        this.reservingDate = reservingDate;
    }

    void setReturningDate(String returningDate) {
        this.returningDate = returningDate;
    }

    String getReturningDate() {
        return returningDate;
    }

    String getDateRange() {
        return dateRange;
    }

    public String getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
