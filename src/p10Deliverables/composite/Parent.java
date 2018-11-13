package p10Deliverables.composite;

import java.util.ArrayList;
import java.util.List;

public class Parent extends FamilyMember {

    List<FamilyMember> members;

    public Parent(String name){
        this.name = name;
        members = new ArrayList<>();
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: "+name);
        for(FamilyMember member: members){
            member.print(indent+indent);
        }
    }

    public void addChild(FamilyMember member){
        if(!members.contains(member))
            members.add(member);
    }
}
