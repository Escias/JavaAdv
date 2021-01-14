package com.company.classes;

import java.util.ArrayList;
import java.util.List;

public class BookingMenu {
    public static List<Booking> bookings = new ArrayList();

    public static void Add(String matriculeNumber,String socialSecurityNumber, String customerName,String why, String duration, String chamber){
        Booking booking = new Booking(matriculeNumber,socialSecurityNumber,customerName,why,duration,chamber);
        bookings.add(booking);
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
