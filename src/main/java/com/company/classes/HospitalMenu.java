package com.company.classes;

import java.util.Scanner;

public class HospitalMenu {

    public void Menu(){
        System.out.println("Doctor menu\n" +
                "Customer menu\n" +
                "Appointment menu\n" +
                "Booking menu\n" +
                "Exit");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.contains("Doctor")){
            DoctorMenu();
        }else if (choice.contains("Customer")){
            CustomerMenu();
        }else if (choice.contains("Appointment")){

        }else if (choice.contains("Booking")){
            BookingMenu();
        }else if (choice.contains("Exit")){
            return;
        }
    }

    private void DoctorMenu(){
        System.out.println("[1] Add doctor\n" +
                "[2] View information\n" +
                "[3] Modify information\n" +
                "[4] Return");
        Scanner doc = new Scanner(System.in);
        int choice = doc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter matricule,last name, first name, speciality, grade, price");
                Scanner info = new Scanner(System.in);
                String information = info.nextLine();
                String[] doctor = information.split(",");
                System.out.println(doctor[1]);
                DoctorMenu.Add(doctor[0], doctor[1], doctor[2], doctor[3], doctor[4], doctor[5]);
                System.out.println("Added");
                DoctorMenu();
                break;
            case 2:
                System.out.println("Enter first name");
                Scanner v = new Scanner(System.in);
                String view = v.nextLine();
                DoctorMenu.View(view);
                DoctorMenu();
                break;
            case 3:
                System.out.println("Enter first name,field to change, new value");
                Scanner m = new Scanner(System.in);
                String modify = m.nextLine();
                String[] modif = modify.split(",");
                DoctorMenu.Modify(modif[0], modif[1], modif[2]);
                DoctorMenu();
                break;
            case 4:
                Menu();
                break;
        }
    }

    private void CustomerMenu(){
        System.out.println("[1] Add Customer\n" +
                "[2] View information\n" +
                "[3] Modify information\n" +
                "[4] Return");
        Scanner cus = new Scanner(System.in);
        int choice = cus.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter social security number,last name, first name, address, phone, mail");
                Scanner info = new Scanner(System.in);
                String information = info.nextLine();
                String[] customer = information.split(",");
                CustomerMenu.Add(customer[0], customer[1], customer[2], customer[3], customer[4], customer[5]);
                System.out.println("Added");
                CustomerMenu();
                break;
            case 2:
                System.out.println("Enter first name");
                Scanner v = new Scanner(System.in);
                String view = v.nextLine();
                CustomerMenu.View(view);
                CustomerMenu();
                break;
            case 3:
                System.out.println("Enter first name,field to change, new value");
                Scanner m = new Scanner(System.in);
                String modify = m.nextLine();
                String[] modif = modify.split(",");
                CustomerMenu.Modify(modif[0], modif[1], modif[2]);
                CustomerMenu();
                break;
            case 4:
                Menu();
                break;
        }
    }

    public void BookingMenu(){
        System.out.println("[1] Add reservation\n" +
                "[2] Modify a reservation\n" +
                "[3] View reservation\n" +
                "[4] Cancel a reservation\n" +
                "[5] View Invoice\n" +
                "[6] Return");
        Scanner c = new Scanner(System.in);
        int choice = c.nextInt();
        switch (choice){
            case 1:
                System.out.println("reason, duration");
                Scanner info = new Scanner(System.in);
                String information = info.nextLine();
                String[] booking = information.split(",");
                BookingMenu bookingMenu = new BookingMenu();
                bookingMenu.Add(booking[0],booking[1]);
                BookingMenu();
                break;
            case 2:
                System.out.println("Enter customer first name,field to change, new value");
                Scanner m = new Scanner(System.in);
                String modif = m.nextLine();
                String[] modify = modif.split(",");
                BookingMenu.Modify(modify[0], modify[1], modify[2]);
                BookingMenu();
                break;
            case 3:
                System.out.println("Enter customer name");
                Scanner v = new Scanner(System.in);
                String view = v.nextLine();
                BookingMenu.View(view);
                BookingMenu();
                break;
            case 4:
                System.out.println("Enter customer name");
                Scanner ca = new Scanner(System.in);
                String cancel = ca.nextLine();
                BookingMenu.CancelBooking(cancel);
                BookingMenu();
                break;
            case 5:
                System.out.println("Enter customer name");
                Scanner in = new Scanner(System.in);
                String invoice = in.nextLine();
                InvoiceData.View(invoice);
                BookingMenu();
                break;
            case 6:
                Menu();
                break;
        }
    }
}
