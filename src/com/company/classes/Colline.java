package com.company.classes;

import com.company.interfaces.Lieux;

import java.util.Scanner;

public class Colline extends GameFeatures implements Lieux {


    @Override
    public void presentationLieux() {
        System.out.println("Vous êtes tout en haut d’une colline qui surplombe la ville, au loin vous voyez une ombre se déplacer a grande vitesse avec un grand couteau.");
        System.out.println("N. Forêt");
        System.out.println("Aller dans la forêt ?");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        choix(choice);
    }

    @Override
    public void choix(String choice) {
        switch (choice){
            case "N":
                Foret foret = new Foret();
                foret.presentationLieux();
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
