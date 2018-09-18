package ui;

public class Community {

    public String name;
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



    //Effect: number of members in community

    //++ before members changes members and returns the new value
    public void birth(){
        int temp = ++members;
        print("birth", temp);

    }

    public void death(){
        int temp = --members;
        print("death", temp);
    }

    //Effects: prints info about community
    public void print(){
        System.out.print(name + " has "+members+ " members and is located in "+province+ " with zipcode "+zipcode+". ");
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
