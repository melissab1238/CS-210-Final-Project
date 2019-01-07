package model;


import p10Deliverables.observer.Subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CommunityMap extends Subject{

    public static Map<String, Community> communities;

    //Constructor
    //EFFECTS: creates new list, calls run()
    public CommunityMap() throws IOException, Subject {
       communities = new HashMap<>();
    }


    public static void loadFromFile(String fileName){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
            addToCommunities(lines);
            System.out.println("File is loaded.");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public Map<String, Community> getCommunities() {
        return communities;
    }

    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public static void saveToFile(){
            PrintWriter writer = null;
            try {
                writer = new PrintWriter("outputFile.txt", "UTF-8");
                printToWriter(writer);
                writer.close(); //do not delete!
                System.out.println("File is saved. ");
            } catch (Throwable e) {
                System.out.println("File not found");
            }
    }

    private static void printToWriter(PrintWriter writer){
        for (Community c : communities.values())
            writer.println(c.getName() + " " + c.getPopulation() + " " + c.getZipcode() + " " + c.getLanguage());
    }

    private static void addToCommunities(List<String> lines){
        for (String line : lines){
            ArrayList<String> partsOfLine = splitOnSpace(line);
            Community community = new Community(partsOfLine.get(0), Integer.parseInt(partsOfLine.get(1)), partsOfLine.get(2), partsOfLine.get(3));
            communities.put(partsOfLine.get(0), community);
            notifyObserver(community.getName());
        }
    }

    //P10deliverables NOTIFY OBSERVER
    public void addCommunities(Community community){
        communities.put(community.getName(), community);
        notifyObserver(community.getName());
    }
}




