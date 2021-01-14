package com.company.classes;

import java.util.*;


public class Lieu {
    int id;
    //String name;
    String description;
    Map<Integer, String> direction = new HashMap();

    public Lieu(int id, String name, String description) {
        this.id = id;
       // this.name = name;
        this.description = description;
        attributeDirection();
    }

    public void changePlace(int id){
        switch (id){
            case 1:
                this.id = 1;
                this.description = "Vous êtes au bout de la route devant un petit immeuble en brique. Un petit ruisseau coule a côté du building en bas d’une rigole.\n";
                break;
            case 2 :
                this.id = 2;
                this.description = "Vous êtes tout en haut d’une colline qui surplombe la ville, au loin vous voyez une ombre se déplacer a grande vitesse avec un grand couteau.\n";
                break;
            case 3 :
                this.id = 3;
                this.description = "Vous êtes a l’intérieur d’un building en brique, un petit refuge pour les bêtes. Un homme git là au milieu d’une marre de sang.\n";
                break;
            case 4 :
                this.id = 4;
                this.description = "Vous êtes dans une vallée a coté d’un ruisseau. Un corps flotte là dans l’eau.\n";
                break;
            case 5 :
                this.id = 5;
                this.description = "Vous êtes dans la foret noire. Vous entendez des hurlements stridents.\n";
        }
    }

    public void attributeDirection(){
        switch(this.id){
            case 1:
                direction.clear();
                direction.put(5, "N -> se rendre vers la forêt");
                direction.put(2, "W -> se rendre vers la colline");
                direction.put(3, "E -> se rendre vers le building");
                direction.put(4, "S -> se rendre vers la vallée");
                break;
            case 2 :
                direction.clear();
                direction.put(5, "N -> se rendre vers la forêt");
                break;
            case 3 :
                direction.clear();
                direction.put(1, "W -> se rendre vers la route");
                break;
            case 4 :
                direction.clear();
                direction.put(1, "N -> se rendre vers la route\n ou");
                direction.put(2, "W -> se rendre vers la colline");
                break;
            case 5 :
                direction.clear();
                direction.put(1, "S -> se rendre vers la route");
                break;

        }
    }
}
