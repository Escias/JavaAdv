package com.company.classes;

public class Customer {
    public String socialSecurityNumber;
    public String lastName;
    public String firstName;
    public String address;
    public String phone;
    public String mail;

    public Customer(String socialSecurityNumber,String lastName, String firstName,String address, String phone, String mail){
        this.socialSecurityNumber=socialSecurityNumber;
        this.lastName=lastName;
        this.firstName=firstName;
        this.address=address;
        this.phone=phone;
        this.mail=mail;
    }
}
