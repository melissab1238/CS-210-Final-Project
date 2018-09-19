package model;

public class
Community {

    public String name;
    private int population;
    private static String province; //**
    private String zipcode;
    private String language;


    //constructor
    public Community(String n, int p, String zipcode, String language){
        name = n;
        population = p;
        province = "BC";
        this.zipcode = zipcode;
        this.language = language;
    }


    //Setters
    public void setName(String n) {this.name = n; }
    public void setPopulation (int p) {this.population= p; }
    public void setZipcode (String z) {this.zipcode = z; }
    public void setLanguage (String l) {this.language = l; }

    //Getters
    public String getName() {return this.name; }
    public int getPopulation() {return this.population; }
    public String getProvince() {return province; }
    public String getZipcode() {return this.zipcode; }
    public String getLanguage() {return this.language; }

    //Effect: number of members in community

    //++ before members changes members and returns the new value
    public void birth(){
        print("birth", ++population);
    }

    public void death(){
        print("death", --population);
    }

    //Effects: prints info about community
    public void print(){
        System.out.print(name + " has "+population+ " members and is located in "+province+ " with zipcode "+zipcode+". ");
        System.out.println(name + " speaks the language of "+language +".");
        System.out.println();

    }

    //Effects: prints info about community
    public void print(String lifeEvent, int i){
        System.out.print("There was a "+lifeEvent+". ");
        System.out.println("The new population of "+this.name+" is "+ i +". ");
        System.out.println();
    }
}
