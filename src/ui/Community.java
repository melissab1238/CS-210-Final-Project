package ui;

public class Community {

    private String name;
    private int members;
    private static String province;
    private String zipcode;
    private String language;

    //constructor
    public Community(String n, int m, String zipcode, String language){
        name = n;
        members = m;
        province = "BC";
        this.zipcode = zipcode;
        this.language = language;

    }

    public void birth(){
        members++;
        System.out.println("There was a birth.");
    }

    public void death(){
        members--;
        System.out.println("There was a death.");
    }

    public void print(){
        System.out.println(name + " has "+members+ " members and is located in "+province+ " with zipcode "+zipcode+".");
        System.out.println(name + " speaks the language of "+language +".");
        System.out.println();

    }
}
