package model;

public interface CommunityInterface {

    void changeName(String s);
     void changePopulation (int p);
     void changeZipcode (String z);
     void changeLanguage (String l);

     String getName() ;
     int getPopulation();
     String getProvince();
     String getZipcode();
     String getLanguage();

}
