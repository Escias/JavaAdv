package com.company.classes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Lieu {
    int id;
    String name;
    String description;
    Map<String, Integer> direction = new HashMap();;


    public Lieu(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        attributeDirection();
    }

    public void attributeDirection(){
        switch(this.name){
            case "route":
                direction.clear();
                direction.put("N -> se rendre vers la forêt", 5);
                direction.put("W -> se rendre vers la colline", 2);
                direction.put("E -> se rendre vers la building", 3);
                direction.put("S -> se rendre vers la vallée", 4);
                break;
            case "coline":
                direction.clear();
                direction.put("N.foret", 5);
                break;
            case "building en brique":
                direction.clear();
                direction.put("W.route", 1);
                break;
            case "valée":
                direction.clear();
                direction.put("N.route", 1);
                direction.put("W.coline", 2);
                break;
        }
    }
}
