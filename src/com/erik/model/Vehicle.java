package com.erik.model;

public class Vehicle {
    private int ID;
    private int year;
    private boolean transmission;    // false - manual, true - auto
    private short siegeCount;
    private short portCount;
    private short consummation;
    private int chevaux;
    private short cylindersNum;
    private String bodyType;
    private String marque;
    private String model;
    private String color;
    private boolean availability;
    private String carburant;
    private String imageURL;
    private String type;
    private float price;

    public int getID() {
        return ID;
    }

    public short getSiegeCount() {
        return siegeCount;
    }

    public short getConsummation() {
        return consummation;
    }

    public void setConsummation(short consummation) {
        this.consummation = consummation;
    }

    public boolean isTransmission() {
        return transmission;
    }

    public void setTransmission(boolean transmission) {
        this.transmission = transmission;
    }

    public short getPortCount() {
        return portCount;
    }

    public void setPortCount(short portCount) {
        this.portCount = portCount;
    }

    public void setSiegeCount(short siegeCount) {
        this.siegeCount = siegeCount;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMarque() {
        return marque;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getChevaux() {
        return chevaux;
    }

    public void setChevaux(int chevaux) {
        this.chevaux = chevaux;
    }

    public short getCylindersNum() {
        return cylindersNum;
    }

    public void setCylindersNum(short cylindersNum) {
        this.cylindersNum = cylindersNum;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
