package com.company.classes;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.company.classes.Appointment.parseDate;

public class AppointmentMenu {
    public static List<Appointment> appointments = new ArrayList<>();
    static Map<String, String> months = new HashMap<>(){{
        put("Jan","1");put("Feb","2");put("Mar","3");put("Apr","4");
        put("May","5");put("Jun","6");put("Jul","7");put("Aug","8");
        put("Sep","9");put("Oct","10");put("Nov","11");put("Dec","12");
    }};
    static Map<String, String> days = new HashMap<>(){{
        put("Mon","1");put("Tue","2");put("Wed","3");
        put("Thu","4");put("Fri","5");put("Sat","6");
        put("Sun","7");
    }};

    public static void Add(String docName,String customerName,String date){
        Appointment appointment = new Appointment(docName,customerName,date);
        appointments.add(appointment);
    }

    public static void Delete(String date){
        Appointment appointment=getAppointmentToModify(date);
        int appointmentId=appointments.indexOf(appointment);
        if(appointmentId==-1){
            System.out.println("appointment doesn't exist");
            return;
        }
        appointments.remove(appointmentId);
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
        appointmentToModify = getAppointmentToModify(date);
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

    private static Appointment getAppointmentToModify(String date) {
        Date parsedDate=parseDate(date);
        for (Appointment appointment:appointments){
            if(appointment.date.equals(parsedDate)){
                return appointment;
            }
        }
        return null;
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

            String[] splittedDate=appointmentInfo.get("date").toString().split(" ");
            String year = splittedDate[5];
            String month ="-"+months.get(splittedDate[1]);
            String day =("-"+days.get(splittedDate[0]));
            String[] hours = splittedDate[3].split(":");
            String hour =("-"+hours[0]);
            String date = year+month+day+hour;


            Appointment appointment= new Appointment(appointmentInfo.get("docName").toString(),
                    appointmentInfo.get("customerName").toString(),
                    date);

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
            appointmentDetails.put("date",appointment.date).toString();

            appointmentList.put(appointmentDetails);

        }
        FileWriter file = new FileWriter("appointments.json");
        file.write(appointmentList.toString());
        file.flush();
    }
}
