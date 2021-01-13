package com.company.classes;

import java.util.ArrayList;
import java.util.List;

public class CustomerMenu {
    public static List<Customer> customers = new ArrayList();

    public static void Add(String socialSecurityNumber,String lastName, String firstName,String address, String phone, String mail){
        Customer customer = new Customer(socialSecurityNumber, lastName, firstName, address, phone, mail);
        customers.add(customer);
    }

    public static void View(String customerName) {
        Customer customer=getCustomer(customerName);
        System.out.println("N°:"+customer.socialSecurityNumber);
        System.out.println("Name"+customer.lastName);
        System.out.println("First name:"+customer.firstName);
        System.out.println("Speciality:"+customer.address);
        System.out.println("Grade:"+customer.phone);
        System.out.println("Price per hour:"+customer.mail);
    }

    public static void Modify(String name,String elementToChange,String newValue){
        Customer customer = getCustomer(name);
        if ("socialSecurityNumber".equals(elementToChange)) {
            customer.socialSecurityNumber = newValue;
        } else if ("lastName".equals(elementToChange)) {
            customer.lastName = newValue;
        } else if ("firstName".equals(elementToChange)) {
            customer.firstName = newValue;
        } else if ("address".equals(elementToChange)) {
            customer.address = newValue;
        } else if ("phone".equals(elementToChange)) {
            customer.phone = newValue;
        } else if ("mail".equals(elementToChange)) {
            customer.mail = newValue;
        }
    }
    public static Customer getCustomer(String name){
        for (Customer customer:customers) {
            if(customer.firstName.equals(name)){
                return customer;
            }
        }
        return null;
    }
}
