package com.company.classes;

public class Lieux {

    String name;
    String description;

    public Lieux(String name, String description, String[] directions) {
        this.name = name;
        this.description = description;
        this.directions = directions;
    }

    String[] directions;

}
