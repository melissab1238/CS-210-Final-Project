package p10Deliverables.composite;

public class Child extends FamilyMember {

    public Child(String name){
        this.name = name;
    }
    @Override
    public void print(String indent) {
        System.out.println(indent + "File: " + name);

    }
}
