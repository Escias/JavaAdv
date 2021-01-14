package com.company.classes;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingMenu {
    public static List<Booking> bookings = new ArrayList();

    public void Add(String matriculeNumber, String socialSecurityNumber, String customerName, String why, String duration){
        System.out.println("Select chamber");
        Scanner ch = new Scanner(System.in);
        String chamber = ch.nextLine();
        boolean check = ValidityChamber(chamber);
        do {
            while (!check){
                System.out.println("Unavailable / Select new chamber");
                chamber = ch.next();
                check = ValidityChamber(chamber);
            }
            chamber = ch.nextLine();
        } while (check);
        Booking booking = new Booking(matriculeNumber,socialSecurityNumber,customerName,why,duration,chamber);
        bookings.add(booking);
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

    public static void View(String customerName) {
        Booking booking=getBooking(customerName);
        if (booking == null){
            System.out.println("not found");
        }else {
            System.out.println("Doctor N°:" + booking.matriculeNumber);
            System.out.println("Customer N°" + booking.socialSecurityNumber);
            System.out.println("Customer Name : " + booking.customerName);
            System.out.println("Why : " + booking.why);
            System.out.println("Duration : " + booking.duration);
            System.out.println("Chamber : " + booking.chamber);
        }
    }

    public static Booking getBooking(String name){
        for (Booking booking:bookings) {
            if(booking.customerName.equals(name)){
                return booking;
            }
        }
        return null;
    }
}
