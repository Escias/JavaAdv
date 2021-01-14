package com.company.classes;

import java.util.Scanner;

public class HospitalMenu {

    public void Menu(){
        System.out.println("Doctor menu\n" +
                "Customer menu\n" +
                "Appointment menu\n" +
                "Booking menu");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (choice.contains("Doctor")){
            DoctorMenu();
        }else if (choice.contains("Customer")){
            CustomerMenu();
        }else if (choice.contains("Appointment")){
            AppointmentMenu();
        }else if (choice.contains("Booking")){

        }
        else if(choice.contains("exit")){
            return;
        }
    }

    private void DoctorMenu(){
        System.out.println("[1] Add doctor\n" +
                "[2] View information\n" +
                "[3] Modify information");
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
                Menu();
                break;
            case 2:
                System.out.println("Enter first name");
                Scanner v = new Scanner(System.in);
                String view = v.nextLine();
                DoctorMenu.View(view);
                Menu();
                break;
            case 3:
                System.out.println("Enter first name,field to change, new value");
                Scanner m = new Scanner(System.in);
                String modify = m.nextLine();
                String[] modif = modify.split(",");
                DoctorMenu.Modify(modif[0], modif[1], modif[2]);
                Menu();
                break;
        }
    }

    private void CustomerMenu(){
        System.out.println("[1] Add Customer\n" +
                "[2] View information\n" +
                "[3] Modify information");
        Scanner cus = new Scanner(System.in);
        int choice = cus.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter social security number,last name, first name, address, phone, mail");
                Scanner info = new Scanner(System.in);
                String information = info.nextLine();
                String[] customer = information.split(",");
                System.out.println(customer[1]);
                CustomerMenu.Add(customer[0], customer[1], customer[2], customer[3], customer[4], customer[5]);
                System.out.println("Added");
                Menu();
                break;
            case 2:
                System.out.println("Enter first name");
                Scanner v = new Scanner(System.in);
                String view = v.nextLine();
                CustomerMenu.View(view);
                Menu();
                break;
            case 3:
                break;
        }
    }
    private void AppointmentMenu(){
        System.out.println("[1] Add appointment\n" +
                "[2] View appointment\n" +
                "[3] Modify appointment");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter doctor name,customer name, date");
                Scanner info = new Scanner(System.in);
                String information = info.nextLine();
                String[] appointment = information.split(",");
                System.out.println(appointment[1]);
                AppointmentMenu.Add(appointment[0], appointment[1], appointment[2]);
                System.out.println("Added");
                Menu();
                break;
            case 2:
                System.out.println("Enter doc name,customer name");
                Scanner v = new Scanner(System.in);
                String[] view = v.nextLine().split(",");
                AppointmentMenu.View(view[0],view[1]);
                Menu();
                break;
            case 3:
                System.out.println("Enter date,field to change, new value");
                Scanner m = new Scanner(System.in);
                String modify = m.nextLine();
                String[] modif = modify.split(",");
                AppointmentMenu.Modify(modif[0], modif[1], modif[2]);
                Menu();
                break;
        }
    }
}
