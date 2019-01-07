package model;

import exceptions.ZeroPopulationError;

import java.util.Objects;

public class Community{

    protected String name;
    protected int population;
    protected String zipcode;
    protected String language;

    //Constructor
    public Community(String n, int p, String zipcode, String language){
        name = n;
        population = p;
        this.zipcode = zipcode;
        this.language = language;
    }

    //Setters
    //Modifies: this
    public void changeName(String n) {this.name = n; }
    public void changePopulation (int p) {this.population= p; }
    public void changeZipcode (String z) {this.zipcode = z; }
    public void changeLanguage (String l) {this.language = l; }

    //Getters
    //Effect: returns description about Community
    public String getName() {return this.name; }
    public int getPopulation() {return this.population; }
    public String getZipcode() {return this.zipcode; }
    public String getLanguage() {return this.language; }

    //Modifies: this
    //Effect: prints birth information
    public void birth(){
        printLifeEvent("birth", ++population); //modifies this.population
    }

    //Modifies: this
    //Effect: prints death information
    public void death() throws ZeroPopulationError {
        if(population == 0)
            throw new ZeroPopulationError();
        printLifeEvent("death", --population);
    }

    //Effects: prints info about community  //TODO: print to a different document (call it "readable document" or something like that)
    public void print(){
        System.out.print(name + " has "+population+ " members and is located in zipcode "+zipcode+". ");
        System.out.println(name + " speaks the language of "+language +".");
        //System.out.println();

    }

    //P9deliverables
    //Effects: prints info about community
    public void printLifeEvent(String lifeEvent, int i){
        System.out.print("There was a "+lifeEvent+". ");
        System.out.println("The new population of "+this.name+" is "+ i +". ");
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Community community = (Community) o;
        return Objects.equals(name, community.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
