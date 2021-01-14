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

    public static String CheckValidity(String name){
        Doctor doctor = getDoctor(name);
        assert doctor != null;
        return doctor.matriculeNumber;
    }

    public static Doctor getDoctor(String name){
        for (Doctor doctor:doctors) {
            if(doctor.firstName.equals(name)){
                return doctor;
            }else if(doctor.lastName.equals(name)){
                return doctor;
            }else if(doctor.matriculeNumber.equals(name)){
                return doctor;
            }
        }
        return null;
    }

    public static void loadDoctors() throws IOException, ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        FileReader reader;
        try {
            reader = new FileReader("doctors.json");
        }
        catch(Exception e){
            return;
        }

        org.json.simple.JSONArray doctorsList = (org.json.simple.JSONArray) jsonParser.parse(reader);
        for (Object doctorInfoObject:doctorsList)
        {
            org.json.simple.JSONObject doctorInfo = (org.json.simple.JSONObject) doctorInfoObject;
            Doctor doctor= new Doctor(doctorInfo.get("matriculeNumber").toString(),
                    doctorInfo.get("lastName").toString(),
                    doctorInfo.get("firstName").toString(),
                    doctorInfo.get("speciality").toString(),
                    doctorInfo.get("grade").toString(),
                    doctorInfo.get("price").toString());
            doctors.add(doctor);
        }
    }

    public static void saveDoctors() throws IOException {
        JSONArray doctorsList = new JSONArray();
        for (Doctor doctor:doctors)
        {
            JSONObject doctorDetails=new JSONObject();
            doctorDetails.put("matriculeNumber",doctor.matriculeNumber);
            doctorDetails.put("lastName",doctor.lastName);
            doctorDetails.put("firstName",doctor.firstName);
            doctorDetails.put("speciality",doctor.speciality);
            doctorDetails.put("grade",doctor.grade);
            doctorDetails.put("price",doctor.price);

            doctorsList.put(doctorDetails);

        }
        FileWriter file = new FileWriter("doctors.json");
        file.write(doctorsList.toString());
        file.flush();
    }
}
