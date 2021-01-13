package main.java.com.company.classes;

import java.util.ArrayList;
import java.util.List;

public class CustomerMenu {
    public static List<Customer> customers = new ArrayList<>();

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
        switch (elementToChange){
            case "socialSecurityNumber":
                customer.socialSecurityNumber=newValue;
                break;
            case "lastName":
                customer.lastName=newValue;
                break;
            case "firstName":
                customer.firstName=newValue;
                break;
            case "address":
                customer.address=newValue;
                break;
            case "phone":
                customer.phone=newValue;
                break;
            case "mail":
                customer.mail=newValue;
                break;
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
