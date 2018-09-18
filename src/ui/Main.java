package ui;

import java.util.ArrayList;
import java.util.Scanner;

//import Java Fx - plans to make a GUI (or use Swing and use JFrame...)


public class Main {
    public static void main(String[] args) {
        ArrayList<Community> communities = new ArrayList<>();
        Community musqueam = new Community("Musqueam", 1300, "V6N 4C6", "hən̓q̓əmin̓əm'");
        musqueam.print();

        communities.add(musqueam);

        Community mostRecent;
        mostRecent = musqueam;
        Scanner scanner = new Scanner(System.in);


        String operation;

        while (true) {
            System.out.println("Pick an option: 'add', 'birth', 'death', 'pick from list', 'quit' ");
            operation = scanner.nextLine();
            if (operation.equals("add")) {
                System.out.print("Enter new community name: "); //... or pick from list //or continue from most recent
                String communityName1 = scanner.nextLine();
                System.out.print("Enter popoultion of " + communityName1 + ": ");
                int population1 = Integer.parseInt(scanner.nextLine()); //create guard if someone types *not int (string)*
                System.out.print("Enter zipcode of " + communityName1 + ": ");
                String zipcode1 = scanner.nextLine();
                System.out.print("Enter language of " + communityName1 + ": ");
                String language1 = scanner.nextLine();

                Community community1 = new Community(communityName1, population1, zipcode1, language1);
                community1.print();
                communities.add(community1);

                mostRecent = community1;

//                System.out.println("Please select an an option");
//                System.out.println("birth or death");
//                operation = scanner.nextLine();
            }
            if (operation.equals("birth")) {
                mostRecent.birth();
            }
            if (operation.equals("death")) {
                mostRecent.death();
            }
            if (operation.equals("pick from list")){
                int temp = 0;
                for (Community c: communities) {
                    System.out.println(temp+1 + ". "+c.name);
                    temp++;
                }
                //inc
                /*
                goal: if you type "1" or "Musqueam" then set musqueam to mostRecent
                 */

            }
            if (operation.equals("quit")) {
                break;
            }

        }
    }
}