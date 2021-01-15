package com.company.classes;

public class Invoice {
    public String customerName;
    public String duration;
    public String amount;

    public Invoice(String customerName, String duration, String amount){
        this.customerName=customerName;
        this.duration=duration;
        this.amount=amount;
    }
}
