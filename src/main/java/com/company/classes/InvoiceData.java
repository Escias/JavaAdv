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

public class InvoiceData {
    public static List<Invoice> invoices = new ArrayList();

    public static void Create(String matricule, String customerName){
        String duration = BookingMenu.getDuration(customerName);
        int price = (Integer.parseInt(DoctorMenu.getPrice(matricule))*Integer.parseInt(BookingMenu.getDuration(customerName)))+(Integer.parseInt(BookingMenu.getDuration(customerName))*100);
        String amount = String.valueOf(price);
        Invoice invoice = new Invoice(customerName, duration, amount);
        invoices.add(invoice);
        View(customerName);
    }

    public static void View(String name){
        Invoice invoice = getInvoice(name);
        if (invoice == null) {
            System.out.println("Invoice not found");
        }else{
            System.out.println("Customer : "+invoice.customerName);
            System.out.println("Duration : "+invoice.duration);
            System.out.println("Amount : "+invoice.amount);
        }
    }

    public static Invoice getInvoice(String name){
        for (Invoice invoice:invoices) {
            if(invoice.customerName.equals(name)){
                return invoice;
            }
        }
        return null;
    }

    public static void loadInvoice() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader;
        try {
            reader = new FileReader("invoices.json");
        }
        catch(Exception e){
            return;
        }
        org.json.simple.JSONArray invoicesList = (org.json.simple.JSONArray) jsonParser.parse(reader);
        for (Object invoiceInfoObject:invoicesList)
        {
            org.json.simple.JSONObject invoiceInfo = (org.json.simple.JSONObject) invoiceInfoObject;
            Invoice invoice= new Invoice(invoiceInfo.get("customerName").toString(),
                    invoiceInfo.get("duration").toString(),
                    invoiceInfo.get("amount").toString());
            invoices.add(invoice);
        }
    }

    public static void saveInvoice() throws IOException {
        JSONArray invoicesList = new JSONArray();
        for (Invoice invoiceConfig:invoices)
        {
            JSONObject invoiceDetails=new JSONObject();
            invoiceDetails.put("floor",invoiceConfig.customerName);
            invoiceDetails.put("chamber",invoiceConfig.duration);
            invoiceDetails.put("status",invoiceConfig.amount);

            invoicesList.put(invoiceDetails);

        }
        FileWriter file = new FileWriter("invoices.json");
        file.write(invoicesList.toString());
        file.flush();
    }
}
