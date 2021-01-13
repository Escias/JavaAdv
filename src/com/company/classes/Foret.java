package com.company.classes;

import com.company.interfaces.Lieux;

import java.util.Scanner;

public class Foret extends GameFeatures implements Lieux {


    @Override
    public void presentationLieux() {
        System.out.println("Vous êtes dans la foret noire. Vous entendez des hurlements stridents.");
        System.out.println("S. Route");
        System.out.println("Retourner à la route ?");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        choix(choice);
    }

    @Override
    public void choix(String choice) {
        switch (choice){
            case "S":
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
