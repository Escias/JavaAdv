package main.java.com.company.classes;

import java.util.ArrayList;
import java.util.List;

public class DoctorMenu {
    public static List<Doctor> doctors = new ArrayList<>();

    public static void Add(String matriculeNumber,String lastName, String firstName,String speciality, String grade, String price){
        Doctor doctor = new Doctor(matriculeNumber, lastName, firstName, speciality, grade, price);
        doctors.add(doctor);
    }

    public static void View(String doctorName) {
        Doctor doctor=getDoctor(doctorName);
        System.out.println("N°:"+doctor.matriculeNumber);
        System.out.println("Name"+doctor.lastName);
        System.out.println("First name:"+doctor.firstName);
        System.out.println("Speciality:"+doctor.speciality);
        System.out.println("Grade:"+doctor.grade);
        System.out.println("Price per hour:"+doctor.price);
    }

    public static void Modify(String name,String elementToChange,String newValue){
        Doctor doctor=getDoctor(name);
        switch (elementToChange){
            case "matriculeNumber":
                doctor.matriculeNumber=newValue;
                break;
            case "lastName":
                doctor.lastName=newValue;
                break;
            case "firstName":
                doctor.firstName=newValue;
                break;
            case "speciality":
                doctor.speciality=newValue;
                break;
            case "grade":
                doctor.grade=newValue;
                break;
            case "price":
                doctor.price=newValue;
                break;
        }
    }
    public static Doctor getDoctor(String name){
        for (Doctor doctor:doctors) {
            if(doctor.firstName.equals(name)){
                return doctor;
            }
        }
        return null;
    }
}
