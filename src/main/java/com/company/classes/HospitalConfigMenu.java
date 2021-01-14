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
import java.util.Scanner;

public class HospitalConfigMenu {
    public static List<Doctor> host = new ArrayList();

    public void Config() throws IOException {
        System.out.println("Config your hospital\n");
        Scanner f = new Scanner(System.in);
        int floor;
        int room;
        do {
            System.out.println("Enter number of floor");
            while (!f.hasNextInt()){
                System.out.println("Enter a number");
                f.next();
            }
            floor = f.nextInt();
        } while (floor <= 0);
        Scanner r = new Scanner(System.in);
        do {
            System.out.println("Enter number of room per floor");
            while (!r.hasNextInt()){
                System.out.println("Enter a number");
                r.next();
            }
            room = r.nextInt();
        }while (room <= 0);
        Add(floor, room);
    }

    public static List<HospitalConfig> hospitals = new ArrayList();

    public void LoadHospital() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("hospital.json");
        org.json.simple.JSONArray hospitalsList = (org.json.simple.JSONArray) jsonParser.parse(reader);
        for (Object hospitalInfoObject:hospitalsList)
        {
            org.json.simple.JSONObject hospitalInfo = (org.json.simple.JSONObject) hospitalInfoObject;
            HospitalConfig hospitalConfig= new HospitalConfig(hospitalInfo.get("floor").toString(),
                    hospitalInfo.get("chamber").toString(),
                    hospitalInfo.get("status").toString());
            hospitals.add(hospitalConfig);
        }
    }

    public void Add(int floor, int room) {
        List<String> chambers = new ArrayList<>();
        HospitalConfig hospitalConfig = null;
        String floorNumber;
        String chamber = null;
        for (int j=0; j <= floor; j++){
            floorNumber = String.valueOf(j);
            for (int i=1; i<=room; i++){
                if (j==0){
                    chamber = String.valueOf(i);
                    chambers.add(chamber);
                }else if (i < 100 && i >= 10){
                    String zero = String.format("%01d", i);
                    chamber = j+zero;
                    chambers.add(chamber);
                }else if (i < 10){
                    String zero = String.format("%02d", i);
                    chamber = j+zero;
                    chambers.add(chamber);
                }
                hospitalConfig = new HospitalConfig(floorNumber, chamber, "Available");
            }
            hospitals.add(hospitalConfig);
        }
    }

    public void saveHospital() throws IOException {
        JSONArray hospitalsList = new JSONArray();
        for (HospitalConfig hospitalConfig:hospitals)
        {
            JSONObject hospitalDetails=new JSONObject();
            hospitalDetails.put("floor",hospitalConfig.floor);
            hospitalDetails.put("chamber",hospitalConfig.chamber);
            hospitalDetails.put("status",hospitalConfig.status);

            hospitalsList.put(hospitalDetails);

        }
        FileWriter file = new FileWriter("hospital.json");
        file.write(hospitalsList.toString());
        file.flush();
    }

    /*public void SaveHospital(int floor, int room) throws IOException {
        JSONArray hospitalList = new JSONArray();
        List<String> chambers = new ArrayList<>();
        String floorNumber;
        String chamber;
        for (int j=0; j <= floor; j++){
            for (int i=1; i<=room; i++){
                if (j==0){
                    String zero = String.valueOf(i);
                    chambers.add(zero);
                }else if (i < 100 && i >= 10){
                    String zero = String.format("%01d", i);
                    chamber = j+zero;
                    chambers.add(chamber);
                }else if (i < 10){
                    String zero = String.format("%02d", i);
                    chamber = j+zero;
                    chambers.add(chamber);
                }
            }
            JSONObject hospitalDetails=new JSONObject();
            floorNumber = String.valueOf(j);
            hospitalDetails.put(floorNumber, chambers);
            hospitalList.put(hospitalDetails);
        }
        FileWriter file = new FileWriter("hospital.json");
        file.write(hospitalList.toString());
        file.flush();
    }*/
}
