package com.company.classes;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;


public class Lieu {
    int id;
    String description;
    Map<Integer, String> direction = new HashMap();
    Config config = new Config();

    public Lieu(int id, String description) {
        this.id = id;
        this.description = description;
        attributeDirection();
    }

    public void changePlace(int id){
        switch (id){
            case 1:
            case 2 :
            case 3 :
            case 4 :
            case 5 :
                this.id = id;
                try {
                    this.description = config.parseDescription(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
        }
    }

    public void attributeDirection(){
        switch(this.id){
            case 1:
            case 2 :
            case 3 :
            case 4 :
            case 5 :
                direction.clear();
                try {
                    this.direction = config.parseDirection(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;

        }
    }
}
