package com.company.classes;

import org.json.simple.parser.ParseException;

import java.io.IOException;

import static com.company.classes.CustomerMenu.loadCustomers;
import static com.company.classes.CustomerMenu.saveCustomers;
import static com.company.classes.DoctorMenu.loadDoctors;
import static com.company.classes.DoctorMenu.saveDoctors;

public class Main {

    public static void main (String[] args) throws IOException, ParseException {
        loadDoctors();
        loadCustomers();

        HospitalMenu menu = new HospitalMenu();
        menu.Menu();

        saveDoctors();
        saveCustomers();
    }
}
