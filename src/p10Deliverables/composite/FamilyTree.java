package p10Deliverables.composite;

public class FamilyTree {

    public static void main(String[] args) {
        Parent pA, pB, pC, pD;

        pA = new Parent("parentA");
        pA.addChild(new Child("childInA"));
        pB = new Parent("parentB");
        pB.addChild(new Child("childInB1"));
        pB.addChild(new Child("childInB2"));
        pA.addChild(pB);
        pC = new Parent("parentC");
        pA.addChild(pC);
        pC.addChild(new Child("childInC"));
        pD = new Parent("parentD");
        pC.addChild(pD);
        pC.addChild(new Child("childInC"));    // Added: Childhas same name as a Parent in "dirC-in-dirA"
        pC.addChild(new Parent("parentInC"));  // Added: Parent has same name as a Childin "dirC-in-dirA"
        pC.addChild(new Child("childInC"));         // Not added: "dirC-in-dirA" already has Childnamed "ChildInC"
        pC.addChild(new Parent("parentInC"));  // Not added: "dirC-in-dirA" already has Parent named "dirD-in-dirC"

        FamilyMember r = pA;
        r.print("\t");

        System.out.println();
        r = pB;
        r.print("\t");
    }
}
