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
import java.util.Scanner;

public class BookingMenu {
    public static List<Booking> bookings = new ArrayList();

    public void Add(String why, String duration){
        System.out.println("Enter customer name or social security number");
        Scanner cu = new Scanner(System.in);
        String customer = cu.nextLine();
        boolean checkCustomer = ValidityCustomer(customer);
        do {
            while (!checkCustomer){
                System.out.println("Customer not found / Enter new social security number or Customer's name");
                customer = cu.nextLine();
                checkCustomer = ValidityCustomer(customer);
            }
        }while (!checkCustomer);
        System.out.println("Select chamber");
        Scanner ch = new Scanner(System.in);
        String chamber = ch.nextLine();
        boolean checkChamber = ValidityChamber(chamber);
        do {
            while (!checkChamber){
                System.out.println("Unavailable / Select new chamber");
                chamber = ch.nextLine();
                checkChamber = ValidityChamber(chamber);
            }
        } while (!checkChamber);
        System.out.println("Enter doctor name or matricule");
        Scanner doc = new Scanner(System.in);
        String doctor = doc.nextLine();
        boolean checkDoctor = ValidityDoctor(doctor);
        do {
            while (!checkDoctor){
                System.out.println("Doctor not Found / Enter new Matricule number or Doctor's name");
                doctor = doc.nextLine();
                checkDoctor = ValidityDoctor(doctor);
            }
        }while (!checkDoctor);
        String matricule = DoctorMenu.CheckValidity(doctor);
        String social = CustomerMenu.CheckValidity(customer);
        String customerName = CustomerMenu.getCustomerName(customer);
        Booking booking = new Booking(matricule,social,customerName,why,duration,chamber);
        bookings.add(booking);
        HospitalConfigMenu.ChangeChamberStatus(chamber, "done");
        InvoiceData.Create(matricule,customerName);
    }

    public boolean ValidityCustomer(String name){
        String validity = CustomerMenu.CheckValidity(name);
        System.out.println(validity);
        if (validity != null){
            return true;
        }else if (validity == null){
            return false;
        }
        return false;
    }

    public boolean ValidityChamber(String chamber){
        String validity = HospitalConfigMenu.checkValidity(chamber);
        if (validity.equals("Available")){
            return true;
        }else if (validity.equals("Unavailable")){
            return false;
        }
        return false;
    }

    public boolean ValidityDoctor(String doctor){
        String validity = DoctorMenu.CheckValidity(doctor);
        System.out.println(validity);
        if (validity != null){
            return true;
        }else if (validity == null){
            return false;
        }
        return false;
    }

    public static void Modify(String customerName, String elementToChange, String newValue){
        Booking booking = getBooking(customerName);
        System.out.println(customerName);
        System.out.println(elementToChange);
        System.out.println(newValue);
        if ("matriculeNumber".equals(elementToChange)){
            booking.matriculeNumber = newValue;
        }else if ("socialSecurityNumber".equals(elementToChange)){
            booking.socialSecurityNumber = newValue;
        }else if ("customerName".equals(elementToChange)){
            booking.customerName = newValue;
        }else if ("why".equals(elementToChange)){
            booking.why = newValue;
        }else if ("duration".equals(elementToChange)){
            booking.duration = newValue;
        }else if ("chamber".equals(elementToChange)){
            try{
                Integer.parseInt(newValue);
            }catch (NumberFormatException e){
                return;
            }
            String oldChamber = getChamber(customerName);
            booking.chamber = newValue;
            HospitalConfigMenu.ChangeChamberStatus(oldChamber, "cancel");
            HospitalConfigMenu.ChangeChamberStatus(newValue, "done");
        }
    }

    public static String getChamber(String name){
        Booking booking = getBooking(name);
        assert booking != null;
        return booking.chamber;
    }

    public static String getDuration(String name){
        Booking booking = getBooking(name);
        assert booking != null;
        return booking.duration;
    }

    public static void View(String customerName) {
        Booking booking=getBooking(customerName);
        if (booking == null){
            System.out.println("Booking not found");
        }else {
            System.out.println("Doctor N°:" + booking.matriculeNumber);
            System.out.println("Customer N°" + booking.socialSecurityNumber);
            System.out.println("Customer Name : " + booking.customerName);
            System.out.println("Why : " + booking.why);
            System.out.println("Duration : " + booking.duration);
            System.out.println("Chamber : " + booking.chamber);
        }
    }

    public static void CancelBooking(String customerName){
        Booking booking = getBooking(customerName);
        HospitalConfigMenu.ChangeChamberStatus(booking.chamber, "cancel");
        bookings.remove(booking);
    }

    public static Booking getBooking(String name){
        for (Booking booking:bookings) {
            if(booking.customerName.equals(name)){
                return booking;
            }else if(booking.chamber.equals(name)){
                return booking;
            }
        }
        return null;
    }

    public static void loadBooking() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader;
        try {
            reader = new FileReader("bookings.json");
        }
        catch(Exception e){
            return;
        }
        org.json.simple.JSONArray bookingsList = (org.json.simple.JSONArray) jsonParser.parse(reader);
        for (Object bookingInfoObject:bookingsList)
        {
            org.json.simple.JSONObject bookingInfo = (org.json.simple.JSONObject) bookingInfoObject;
            Booking booking= new Booking(bookingInfo.get("matriculeNumber").toString(),
                    bookingInfo.get("socialSecurityNumber").toString(),
                    bookingInfo.get("customerName").toString(),
                    bookingInfo.get("why").toString(),
                    bookingInfo.get("duration").toString(),
                    bookingInfo.get("chamber").toString());
            bookings.add(booking);
        }
    }

    public static void saveBooking() throws IOException {
        JSONArray bookingsList = new JSONArray();
        for (Booking booking:bookings)
        {
            JSONObject bookingDetails=new JSONObject();
            bookingDetails.put("matriculeNumber",booking.matriculeNumber);
            bookingDetails.put("socialSecurityNumber",booking.socialSecurityNumber);
            bookingDetails.put("customerName",booking.customerName);
            bookingDetails.put("why",booking.why);
            bookingDetails.put("duration",booking.duration);
            bookingDetails.put("chamber",booking.chamber);

            bookingsList.put(bookingDetails);

        }
        FileWriter file = new FileWriter("bookings.json");
        file.write(bookingsList.toString());
        file.flush();
    }
}
