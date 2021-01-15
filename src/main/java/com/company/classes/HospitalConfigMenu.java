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
    public static List<HospitalConfig> hospitals = new ArrayList();

    public void Config(){
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

    public void Add(int floor, int room) {
        List<String> chambers = new ArrayList<>();
        HospitalConfig hospitalConfig;
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
                hospitals.add(hospitalConfig);
            }
        }
    }

    public static void ChangeChamberStatus(String number, String status){
        HospitalConfig hospitalConfig = getHospitalConfig(number);
        if (status.equals("done")){
            hospitalConfig.status = "Unavailable";
        }else if (status.equals("cancel")){
            hospitalConfig.status = "Available";
        }
    }

    public static void loadHospital() throws IOException, ParseException {
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

    public static void saveHospital() throws IOException {
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

    public static String checkValidity(String chamber){
        HospitalConfig hospitalConfig = getHospitalConfig(chamber);
        assert hospitalConfig != null;
        return hospitalConfig.status;
    }

    public static HospitalConfig getHospitalConfig(String name){
        for (HospitalConfig hospitalConfig:hospitals) {
            if(hospitalConfig.chamber.equals(name)){
                return hospitalConfig;
            }
        }
        return null;
    }
}
