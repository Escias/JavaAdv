package com.company.classes;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMenu {
    public static List<Customer> customers = new ArrayList<>();

    public static void Add(String socialSecurityNumber,String lastName, String firstName,String address, String phone, String mail){
        Customer customer = new Customer(socialSecurityNumber, lastName, firstName, address, phone, mail);
        customers.add(customer);
    }

    public static void Delete(String customerName){
        Customer customer=getCustomer(customerName);
        int customerId=customers.indexOf(customer);
        if(customerId==-1){
            System.out.println("customer doesn't exist");
            return;
        }
        customers.remove(customerId);
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
    public static void loadCustomers() throws IOException, ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        FileReader reader;
        try {
             reader = new FileReader("customers.json");
        }
        catch(Exception e){
            return;
            }
        org.json.simple.JSONArray customersList = (org.json.simple.JSONArray) jsonParser.parse(reader);
        for (Object customerInfoObject:customersList)
        {
            org.json.simple.JSONObject customerInfo = (org.json.simple.JSONObject) customerInfoObject;
            Customer customer= new Customer(customerInfo.get("socialSecurityNumber").toString(),
                    customerInfo.get("lastName").toString(),
                    customerInfo.get("firstName").toString(),
                    customerInfo.get("address").toString(),
                    customerInfo.get("phone").toString(),
                    customerInfo.get("mail").toString());
            customers.add(customer);
        }
    }

    public static void saveCustomers() throws IOException {
        JSONArray customersList = new JSONArray();
        for (Customer customer:customers)
        {
            JSONObject customerDetails=new JSONObject();
            customerDetails.put("socialSecurityNumber",customer.socialSecurityNumber);
            customerDetails.put("lastName",customer.lastName);
            customerDetails.put("firstName",customer.firstName);
            customerDetails.put("address",customer.address);
            customerDetails.put("phone",customer.phone);
            customerDetails.put("mail",customer.mail);

            customersList.put(customerDetails);

        }
        FileWriter file = new FileWriter("customers.json");
        file.write(customersList.toString());
        file.flush();
    }
}
