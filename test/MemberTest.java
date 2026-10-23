import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MemberTest {
    @Test
    void testMemberIDAndName(){
        Member joe = new Member("Joe Mama", 1337);
        assertEquals("Joe Mama", joe.name());
        assertEquals(1337, joe.ID());
    }
}

