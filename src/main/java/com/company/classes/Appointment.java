package com.company.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Appointment {
    public String docName;
    public String customerName;
    public Date date;

    public Appointment(String docName, String customerName, String date) {
        this.docName = docName;
        this.customerName = customerName;
        Date parsedDate = parseDate(date);
        this.date = parsedDate;
    }
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd-HH").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

}
