package com.company.classes;

import com.sun.jdi.Value;

import java.util.Map;
import java.util.Scanner;

public class GameFeatures {
    public void start(){
        System.out.println("Bienvenue dans Colossal Cave ! selon votre position, une ou plusieurs directions seront possibles, représentées par la première lettre des points cardinaux (Nord = N...).\nPour quitter le jeu, entrer la lettre 'Q'\n\n");
        Lieu lieu = new Lieu(1, "route", "Vous êtes au bout de la route devant un petit immeuble en brique. Un petit ruisseau coule a côté du building en bas d’une rigole.\n");
        localisation(lieu);
    }

    public void localisation(Lieu lieu){
        System.out.println(lieu.description);
        for (Map.Entry<String, Integer> entry : lieu.direction.entrySet()) {
            System.out.println(entry.getKey());
        }
        getDirection();
    }

    public void getDirection(){
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "N":
                break;
            case "E":

                break;
            case "O":

                break;
            case "S":

                break;
            case "Q":
                quit();
                break;
            default:
                System.out.println("Entrez un lieu disponible");

                break;
        }
    }

    public void quit(){
        System.out.println("A la prochaine ! merci d'avoir joué !");
        System.exit(0);
    }
}
