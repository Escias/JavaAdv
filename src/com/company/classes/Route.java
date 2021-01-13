package com.company.classes;

import com.company.interfaces.Lieux;

import java.util.Scanner;

public class Route extends GameFeatures implements Lieux {

    Foret foret = new Foret();
    BuildingEnBrique buildingEnBrique = new BuildingEnBrique();
    Colline colline = new Colline();
    Vallee vallee = new Vallee();


    @Override
    public void presentationLieux() {
        System.out.println("Vous êtes au bout de la route devant un petit immeuble en brique. Un petit ruisseau coule a côté du building en bas d’une rigole.");
        System.out.println("Où voulez vous aller ?");
        System.out.println("N. Foret, E.Building en brique, O. Colline, S. Vallée");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();

        choix(choice);
    }

    @Override
    public void choix(String choice) {
        switch (choice) {
            case "N":
                foret.presentationLieux();
                break;
            case "E":
                buildingEnBrique.presentationLieux();
                break;
            case "O":
                colline.presentationLieux();
                break;
            case "S":
                vallee.presentationLieux();
                break;
            case "Q":
                quit();
                break;
            default:
                System.out.println("Entrez un lieu disponible");
                presentationLieux();
                break;
        }
    }
}
