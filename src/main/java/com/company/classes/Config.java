package com.company.classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Config {

    public Map<Integer, String> parseDirection(String id) throws IOException, ParseException {
        Map<Integer, String> directions = new HashMap<Integer, String>();
        JSONParser jsonParser = new JSONParser();
        FileReader reader;
        try {
            reader = new FileReader("gameConfigs/directions.json");
        }catch(Exception e){
            return directions;
        }
        JSONArray parseConfig = (JSONArray) jsonParser.parse(reader);

        for (Object configuration:parseConfig){
            org.json.simple.JSONObject jsonContent = (org.json.simple.JSONObject) configuration;
            JSONArray jsonDirections = (JSONArray) jsonContent.get(id);
            ArrayList<String> directionsList = new ArrayList<>();
            for (Object jsonDirection:jsonDirections) {
                String direction = jsonDirection.toString();
                directionsList.add(direction);
            }

            for (int i = 0; i < directionsList.size(); i=i+2)
            {
                directions.put(parseInt(directionsList.get(i)), directionsList.get(i+1));
            }
        }
        return directions;
    }

    public String parseDescription(String id) throws IOException, ParseException {
        String description = null;
        JSONParser jsonParser = new JSONParser();
        FileReader reader;
        try {
            reader = new FileReader("gameConfigs/descriptions.json");
        }catch(Exception e){
            return "error";
        }
        JSONArray parseConfig = (JSONArray) jsonParser.parse(reader);
        for (Object configuration:parseConfig){
            org.json.simple.JSONObject jsonContent = (org.json.simple.JSONObject) configuration;
            description = jsonContent.get(id).toString();
        }
        return description;
    }
}
