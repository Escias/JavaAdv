package com.company.classes;

import java.util.Scanner;

public class HospitalConfig {

    public void Config(){
        System.out.println("Config your hospital\n");
        Scanner f = new Scanner(System.in);
        int floor;
        int room;
        do {
            System.out.println("Enter number of floor");
            while (!f.hasNextInt()){
                System.out.println("Enter a number");
                f.next();
            }
            floor = f.nextInt();
        } while (floor <= 0);
        Scanner r = new Scanner(System.in);
        do {
            System.out.println("Enter number of room per floor");
            while (!r.hasNextInt()){
                System.out.println("Enter a number");
                r.next();
            }
            room = r.nextInt();
        }while (room <= 0);
        System.out.println("Floor : "+floor);
        System.out.println("Room : "+room);
    }
}
