import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MemberTest {
    @Test
    void testMemberIDAndName(){
        Member joe = new Member("Joe Mama", 1337);
        assertEquals("Joe Mama", joe.name());
        assertEquals(1337, joe.ID());
    }

    @Test
    void membersWithLowerIDComeFirst(){
        Member member1 = new Member("Test", 1);
        Member member2 = new Member("Test", 2);
        int comparisonResult = member1.compareTo(member2);
        assertTrue(comparisonResult < 0);
    }

    @Test
    void membersWithSameIDAreUnsorted(){
        Member member1 = new Member("Test", 1);
        Member member2 = new Member("Test", 1);
        int comparisonResult = member1.compareTo(member2);
        assertEquals(0, comparisonResult);
    }
}

