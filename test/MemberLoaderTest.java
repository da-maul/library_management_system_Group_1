import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberLoaderTest {
    @Test
    void loadmembers() throws IOException {
     var members = List.of(
                new Member("Signe Borch", 1111),
                new Member("Ian Bridgwood", 2222),
                new Member("Jakob Kofoed Janot", 3333)
        );
        var librarySaver = new MemberSaver();
// Act
        librarySaver.saveMembers(members, "test-members.csv");

        MemberLoader memberLoader = new MemberLoader();
        List<Member> membersLoaded = memberLoader.loadMembers("test-members.csv");
        // Assert
        assertEquals(members, membersLoaded);
    }
}