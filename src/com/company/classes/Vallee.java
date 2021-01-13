package com.company.classes;

import com.company.interfaces.Lieux;

import java.util.Scanner;

public class Vallee extends GameFeatures implements Lieux {


    @Override
    public void presentationLieux() {
        System.out.println("Vous êtes dans une vallée a coté d’un ruisseau. Un corps flotte là dans l’eau.");
        System.out.println("N. Route, O. Colline");
        System.out.println("Où voulez vous aller ?");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        choix(choice);
    }

    @Override
    public void choix(String choice) {
        switch (choice){
            case "N":
                Route route = new Route();
                route.presentationLieux();
                break;
            case "O":
                Colline colline = new Colline();
                colline.presentationLieux();
                break;
            case "Q":
                quit();
            default :
                System.out.println("Entrez un lieu disponible");
                presentationLieux();
                break;
        }
    }
}
