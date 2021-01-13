package com.company.classes;

import com.company.interfaces.Lieux;

import java.util.Scanner;

public class BuildingEnBrique extends GameFeatures implements Lieux {


    @Override
    public void presentationLieux() {
        System.out.println("Vous êtes a l’intérieur d’un building en brique, un petit refuge pour les bêtes. Un homme git là au milieu d’une marre de sang.");
        System.out.println("O. Route");
        System.out.println("Retourner à la route ?");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        choix(choice);
    }

    @Override
    public void choix(String choice) {
        switch (choice){
            case "O":
                Route route = new Route();
                route.presentationLieux();
                break;
            case "Q":
                quit();
                break;
            default :
                System.out.println("Entrez un lieu disponible");
                presentationLieux();
                break;
        }
    }
}
