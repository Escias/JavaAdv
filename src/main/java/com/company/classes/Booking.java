package com.company.classes;

public class Booking {
    public String matriculeNumber;
    public String socialSecurityNumber;
    public String customerName;
    public String why;
    public String duration;

    public Booking(String matriculeNumber,String socialSecurityNumber, String customerName,String why, String duration){
        this.matriculeNumber=matriculeNumber;
        this.socialSecurityNumber=socialSecurityNumber;
        this.customerName=customerName;
        this.why=why;
        this.duration=duration;
    }
}
