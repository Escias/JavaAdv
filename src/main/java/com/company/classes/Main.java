package com.company.classes;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

import static com.company.classes.AppointmentMenu.loadAppointments;
import static com.company.classes.AppointmentMenu.saveAppointments;
import static com.company.classes.CustomerMenu.loadCustomers;
import static com.company.classes.CustomerMenu.saveCustomers;
import static com.company.classes.DoctorMenu.loadDoctors;
import static com.company.classes.DoctorMenu.saveDoctors;
import static com.company.classes.HospitalConfigMenu.loadHospital;
import static com.company.classes.HospitalConfigMenu.saveHospital;
import static com.company.classes.BookingMenu.loadBooking;
import static com.company.classes.BookingMenu.saveBooking;
import static com.company.classes.InvoiceData.loadInvoice;
import static com.company.classes.InvoiceData.saveInvoice;

public class Main {

    public static void main (String[] args) throws IOException, ParseException {
        HospitalMenu menu = new HospitalMenu();
        HospitalConfigMenu hospitalConfig = new HospitalConfigMenu();

        loadDoctors();
        loadCustomers();
        loadBooking();
        loadInvoice();
        loadAppointments();

        File check = new File("hospital.json");
        if (check.exists() && !check.isDirectory()){
            loadHospital();
            menu.Menu();
        }else{
            hospitalConfig.Config();
        }

        saveDoctors();
        saveCustomers();
        saveHospital();
        saveBooking();
        saveInvoice();
        saveAppointments();
    }
}
