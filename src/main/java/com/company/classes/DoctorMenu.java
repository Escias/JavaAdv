package com.company.classes;

import java.util.ArrayList;
import java.util.List;

public class DoctorMenu {
    public static List<Doctor> doctors = new ArrayList();

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
        if ("matriculeNumber".equals(elementToChange)) {
            doctor.matriculeNumber = newValue;
        } else if ("lastName".equals(elementToChange)) {
            doctor.lastName = newValue;
        } else if ("firstName".equals(elementToChange)) {
            doctor.firstName = newValue;
        } else if ("speciality".equals(elementToChange)) {
            doctor.speciality = newValue;
        } else if ("grade".equals(elementToChange)) {
            doctor.grade = newValue;
        } else if ("price".equals(elementToChange)) {
            doctor.price = newValue;
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
