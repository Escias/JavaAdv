package com.company.classes;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameFeatures {

    public void start(){
        System.out.println("Bienvenue dans Colossal Cave ! selon votre position, une ou plusieurs directions seront possibles, représentées par la première lettre des points cardinaux (Nord = N...).\nPour quitter le jeu, entrer la lettre 'Q'\n\n");
        Lieu lieu = new Lieu(1,"Vous êtes au bout de la route devant un petit immeuble en brique. Un petit ruisseau coule a côté du building en bas d’une rigole.\n");
        localisation(lieu);
    }

    public void localisation(Lieu lieu) {
        System.out.println(lieu.description);
        for (Map.Entry<Integer, String> entry : lieu.direction.entrySet()) {
            System.out.println(entry.getValue());
        }
        getDirection(copieMap(lieu.direction), lieu );

    }

    public Map<Integer, String> copieMap(Map<Integer, String> direction){
        Map<Integer, String> copie = new HashMap();
        for (Map.Entry<Integer, String> entry : direction.entrySet()) {
            copie.put(entry.getKey(), entry.getValue().substring(0, 1));
        }
        return copie;
    }

    public void guide(String choice, Lieu lieu, Map<Integer, String> direction ) {
        if (direction.containsValue(choice)) {
            for (Map.Entry<Integer, String> entry : direction.entrySet()) {
                if(entry.getValue().equals(choice)){
                    lieu.changePlace(entry.getKey());
                    lieu.attributeDirection();
                    localisation(lieu);
                }
            }
        }else{
            System.out.println("Entrez un lieu disponible");
            localisation(lieu);
        }
    }

    public void getDirection(Map<Integer, String> direction, Lieu lieu) {
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "N":
            case "E":
            case "W":
            case "S":
                guide(choice, lieu, direction);
                break;
            case "Q":
                quit();
                break;
            default:
                System.out.println("Entrez un lieu disponible");
                localisation(lieu);
                break;
        }
    }

    public void quit(){
        System.out.println("A la prochaine ! merci d'avoir joué !");
    }

}
