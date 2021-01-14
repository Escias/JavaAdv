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
                this.id = 1;
                try {
                    this.description = config.parseDescription(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 2 :
                this.id = 2;
                try {
                    this.description = config.parseDescription(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 3 :
                this.id = 3;
                try {
                    this.description = config.parseDescription(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 4 :
                this.id = 4;
                try {
                    this.description = config.parseDescription(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 5 :
                this.id = 5;
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
                direction.clear();
                try {
                    this.direction = config.parseDirection(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 2 :
                direction.clear();
                try {
                    this.direction = config.parseDirection(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 3 :
                direction.clear();
                try {
                    this.direction = config.parseDirection(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 4 :
                direction.clear();
                try {
                    this.direction = config.parseDirection(String.valueOf(this.id));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
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
