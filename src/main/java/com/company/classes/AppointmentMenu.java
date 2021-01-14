package com.company.classes;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.company.classes.Appointment.parseDate;

public class AppointmentMenu {
    public static List<Appointment> appointments = new ArrayList<>();

    public static void Add(String docName,String customerName,String date){
        Appointment appointment = new Appointment(docName,customerName,date);
        appointments.add(appointment);
    }

    public static void View(String docName,String customerName) {
        List<Appointment> appointmentList= getAppointments(docName,customerName);
        for (Appointment appointment:appointmentList)
        {
            System.out.println("doctorname:"+appointment.docName);
            System.out.println("customer name:"+appointment.customerName);
            System.out.println("Date:"+appointment.date);
        }
    }

    public static void Modify(String date, String elementToChange, String newValue){
        Appointment appointmentToModify=new Appointment("","","");
        Date parsedDate=parseDate(date);
        for (Appointment appointment:appointments){
            if(appointment.date.equals(parsedDate)){
                appointmentToModify=appointment;
                break;
            }
        }
        switch (elementToChange){
            case "docName":
                appointmentToModify.docName=newValue;
                break;
            case "customerName":
                appointmentToModify.customerName=newValue;
                break;
            case "date":
                Date newDate=parseDate(newValue);
                appointmentToModify.date=newDate;
                break;
        }
    }

    public static List<Appointment> getAppointments(String docName, String customerName){
        List<Appointment> appointmentList = new ArrayList<>();
        for (Appointment appointment:appointments) {
            if(appointment.docName.equals(docName) && appointment.customerName.equals(customerName)){
                appointmentList.add(appointment);
            }
        }
        return appointmentList;
    }

    public static void loadAppointments() throws IOException, ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        FileReader reader;
        try {
            reader = new FileReader("appointments.json");
        }
        catch(Exception e){
            return;
        }

        org.json.simple.JSONArray appointmentList = (org.json.simple.JSONArray) jsonParser.parse(reader);
        for (Object appointmentInfoObject:appointmentList)
        {
            org.json.simple.JSONObject appointmentInfo = (org.json.simple.JSONObject) appointmentInfoObject;
            Appointment appointment= new Appointment(appointmentInfo.get("docName").toString(),
                    appointmentInfo.get("customerName").toString(),
                    appointmentInfo.get("date").toString());

            appointments.add(appointment);
        }
    }

    public static void saveAppointments() throws IOException {
        JSONArray appointmentList = new JSONArray();
        for (Appointment appointment:appointments)
        {
            JSONObject appointmentDetails=new JSONObject();
            appointmentDetails.put("docName",appointment.docName);
            appointmentDetails.put("customerName",appointment.customerName);
            appointmentDetails.put("date",appointment.date);

            appointmentList.put(appointmentDetails);

        }
        FileWriter file = new FileWriter("appointments.json");
        file.write(appointmentList.toString());
        file.flush();
    }
}
