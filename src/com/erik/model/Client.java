package com.erik.model;

import java.sql.Timestamp;

public class Client {
    private int carID;
    private String name;
    private String surName;

    private String address;
    private String email;
    private Timestamp startDate;
    private Timestamp endDate;

    public Client(String name, String surName, Timestamp startDate, Timestamp endDate, String address, String email) {
        this.name = name;
        this.surName = surName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }
}
