package p10Deliverables.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject extends Throwable {

    static List<Observer> observerList;

    public Subject(){
      observerList = new ArrayList<>();

    }

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    public static void notifyObserver(String communityName){
        for (Observer observer: observerList) {
            observer.update(communityName);
        }
    }
}
