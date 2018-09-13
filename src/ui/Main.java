package ui;

import java.util.ArrayList;
import java.util.Scanner;

//import Java Fx - plans to make a GUI (or use Swing and use JFrame...)


public class Main {
    public static void main(String[] args) {
        ArrayList<Community> communities = new ArrayList<>();
        Community musqueam = new Community("Musqueam",1300, "V6N 4C6", "hən̓q̓əmin̓əm'");
        communities.add(musqueam);

        Community mostRecent;
        mostRecent = musqueam;
        Scanner scanner = new Scanner(System.in);



        String operation;

        while (true){
            System.out.println("Pick an option: 'add', 'birth', 'death', 'quit' ");
            operation = scanner.nextLine();
            if(operation.equals("add")) {
                System.out.print("Enter new community name: "); //... or pick from list //or continue from most recent
                String communityName1 = scanner.nextLine();
                System.out.print("Enter popoultion of " + communityName1 +": ");
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
            if(operation.equals("birth")) {
                int temp = mostRecent.birth();
                System.out.print("There was a birth. ");
                System.out.println("The population of "+mostRecent.name+" is now "+temp);
                System.out.println();
            }
            if(operation.equals("death")) {
                mostRecent.death();
            }
            //
            if (operation.equals("quit")) {
                break;
            }
//            else {
//                System.out.println("Invalid Input");
//            }

        }


//        communities.get(0).print();
//        communities.get(0).birth();
//        communities.get(0).print();
//        communities.get(0).death();
//        communities.get(0).print();

    }

}

/*
ArrayList<LogEntry> operationLog = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int lastResult = -1;

    public LoggingCalculator(){
        String operation = "";

        while (true){
            System.out.println("Please select an option");
            operation = scanner.nextLine();
            System.out.println("you selected: "+operation);
            int result = 0;
            LogEntry opEntry = new LogEntry();

            if (operation.equals("plus")) {
                opEntry.setOperation(operation);
                result = plus(opEntry, lastResult);
                opEntry.setResult(result);
                lastResult = result;
            }
            if (operation.equals("minus")) {
                opEntry.setOperation(operation);
                result = minus(opEntry);
                opEntry.setResult(result);
                lastResult = result;
            }
            else if (operation.equals("quit")) {
                break;
            }
            System.out.println("that equals: "+result);
            operationLog.add(opEntry);
        }
        System.out.println("operation log: "+operationLog);

    }

    private int plus(LogEntry logEntry, int lastResult) {
        System.out.println("Please enter the first number to plus (Type 'lr' for last result)");
        String temp = scanner.next();
        int first;
        if(temp.equals("lr") && lastResult != -1)
            first = lastResult;
        else
            first = Integer.parseInt(temp);
        System.out.println("Please enter the second number to plus");
        int second = scanner.nextInt();
        scanner.nextLine(); //clears the line,
                            // otherwise the carriage return is taken as the next input
                            // and you get a blank "selected" loop
        logEntry.addOperand(first);
        logEntry.addOperand(second);
        return first + second;
    }

    private int minus(LogEntry logEntry) {
        System.out.println("Please enter the first number");
        int first = scanner.nextInt();
        System.out.println("Please enter the second number to subtract from the first number");
        int second = scanner.nextInt();
        scanner.nextLine(); //clears the line,
        // otherwise the carriage return is taken as the next input
        // and you get a blank "selected" loop
        logEntry.addOperand(first);
        logEntry.addOperand(second);
        return first - second;
 */