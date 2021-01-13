package main.java.com.company.classes;

public class Doctor {
    public String matriculeNumber;
    public String lastName;
    public String firstName;
    public String speciality;
    public String grade;
    public String price;

    public Doctor(String matriculeNumber,String lastName, String firstName,String speciality, String grade, String price){
        this.matriculeNumber=matriculeNumber;
        this.lastName=lastName;
        this.firstName=firstName;
        this.speciality=speciality;
        this.grade=grade;
        this.price=price;
    }
}
