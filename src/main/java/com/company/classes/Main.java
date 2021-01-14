package com.company.classes;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        GameFeatures gameFeatures = new GameFeatures();

        gameFeatures.start();

        //GameFeatures gameFeatures = new GameFeatures();
        //gameFeatures.start();
    }
}
