package p10Deliverables.composite;

import java.util.Objects;

public abstract class FamilyMember {

    protected String name;

    public String getName(){
        return name;
    }

    public abstract void print(String indent);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
