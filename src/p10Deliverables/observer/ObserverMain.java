package p10Deliverables.observer;

import model.Community;
import model.CommunityMap;

import java.io.IOException;

public class ObserverMain {

    public static void main(String[] args) throws IOException, Subject {
        CommunityMap communityMap = new CommunityMap();
        EmailSubscriber paul = new EmailSubscriber("Paul");
        EmailSubscriber elisa = new EmailSubscriber("Elisa");
        EmailSubscriber trey = new EmailSubscriber("Trey");
        Community community1 = new Community("Community 1", 100, "123456", "English");
        Community community2 = new Community("Community 2", 200, "654321", "English");


        communityMap.addObserver(paul);
        communityMap.addObserver(elisa);
        communityMap.addObserver(trey);


        System.out.println("Welcome to " + communityMap.getCommunities() + "\n");
        communityMap.addCommunities(community1);
        System.out.println();
        communityMap.addCommunities(community2);

    }


}
