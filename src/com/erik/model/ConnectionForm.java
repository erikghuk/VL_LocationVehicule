package com.erik.model;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class ConnectionForm {
    String name;
    String surname;
    private String type;
    private String dateD;
    private String dateR;
    private Date dateRes;
    private Date dateRet;

    public void getFormParams(HttpServletRequest request) {

    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    String getType() {
        return type;
    }

    String getDateD() {
        return dateD;
    }

    String getDateR() {
        return dateR;
    }
}
