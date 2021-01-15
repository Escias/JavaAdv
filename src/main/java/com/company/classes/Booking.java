package com.company.classes;

public class Booking {
    public String matriculeNumber;
    public String socialSecurityNumber;
    public String customerName;
    public String why;
    public String duration;
    public String chamber;

    public Booking(String matriculeNumber,String socialSecurityNumber, String customerName,String why, String duration, String chamber){
        this.matriculeNumber=matriculeNumber;
        this.socialSecurityNumber=socialSecurityNumber;
        this.customerName=customerName;
        this.why=why;
        this.duration=duration;
        this.chamber=chamber;
    }
}
