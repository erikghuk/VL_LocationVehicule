package com.erik.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    Date date;
    String startDate, endDate;
    DateFormat sourceFormat;
    public DateConverter(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void convertDate() throws ParseException {
        String dateAsString = startDate;
        date = sourceFormat.parse(dateAsString);
    }
}
