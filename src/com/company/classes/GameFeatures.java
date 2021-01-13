package com.company.classes;

public class GameFeatures {

    public void start(){
        Route route = new Route();
        System.out.println("Bienvenue dans Colossal Cave ! selon votre position, une ou plusieurs directions seront possibles, représentées par la première lettre des points cardinaux (Nord = N...) mais vous pouvez également entrer une phrase votre choix.\nPour quitter le jeu, entrer la lettre 'Q'\n\n");
        route.presentationLieux();
    }

    public void quit(){
        System.out.println("A la prochaine ! merci d'avoir joué !");
        System.exit(0);
    }



}
