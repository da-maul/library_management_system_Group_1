import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarySaverTest {
    @Test
    void testSaveMembers() throws IOException {
// Arrange
        var members = List.of(
                new Member("Signe Borch", 1111),
                new Member("Ian Bridgwood", 2222),
                new Member("Jakob Kofoed Janot", 3333)
        );
        var librarySaver = new LibrarySaver();
// Act
        librarySaver.saveMembers(members, "test-members.csv");
// Assert
        var expected = """
                1111,Signe Borch
                2222,Ian Bridgwood
                3333,Jakob Kofoed Janot
                """;
        // newLine() skriver \r\n på Windows, men tekstblokken bruger \n.
        var actual = Files.readString(Path.of("test-members.csv")).replace("\r\n", "\n");
        assertEquals(expected, actual);
    }
}
