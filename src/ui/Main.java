package ui;

import java.util.ArrayList;

//import Java Fx - plans to make a GUI (or use Swing and use JFrame...)


public class Main {
    public static void main(String[] args) {
        ArrayList<Community> communities = new ArrayList<>();
        Community musqueam = new Community("Musqueam",1300, "V6N 4C6", "hən̓q̓əmin̓əm'");
        communities.add(musqueam);
        communities.get(0).print();
        communities.get(0).birth();
        communities.get(0).print();
        communities.get(0).death();
        communities.get(0).print();

    }
}
