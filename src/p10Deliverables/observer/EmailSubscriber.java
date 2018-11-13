package p10Deliverables.observer;

public class EmailSubscriber implements Observer {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    @Override
    public void update(String communityName) {
        System.out.println(name + " says: Great to hear that "
                + communityName + " was added to the communityMap!");
    }
}
