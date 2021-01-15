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

    public static void View(String customerName) {
        Customer customer=getCustomer(customerName);
        if (customer == null) {
            System.out.println("Customer not found");
        }else{
            System.out.println("N° : "+customer.socialSecurityNumber);
            System.out.println("Name : "+customer.lastName);
            System.out.println("First name : "+customer.firstName);
            System.out.println("Address : "+customer.address);
            System.out.println("Phone : :"+customer.phone);
            System.out.println("Mail : "+customer.mail);
        }
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

    public static String CheckValidity(String name){
        Customer customer = getCustomer(name);
        assert customer != null;
        return customer.socialSecurityNumber;
    }

    public static String getCustomerName(String name){
        Customer customer = getCustomer(name);
        assert customer != null;
        return customer.firstName;
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

    public static Customer getCustomer(String name){
        for (Customer customer:customers) {
            if(customer.firstName.equals(name)){
                return customer;
            }else if (customer.lastName.equals(name)){
                return customer;
            }else if (customer.socialSecurityNumber.equals(name)){
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
