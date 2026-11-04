import java.util.Objects;

public record Member (String name, int ID) implements Comparable<Member> {
    public String toString() {return name+" "+"ID:"+ID;}

    @Override
    public int compareTo(Member otherMember) {
        return ID - otherMember.ID();
    }
}
