import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AudioBookSaverTest {

    @Test
    void testSaveAudioBooks() throws IOException {
        // Arrange
        var audioBooks = List.of(
                new AudioBook("Stephen King", "The Shining", 360, "999-9-9999-9999-9", 4)
        );
        var audioBookSaver = new AudioBookSaver();

        // Act
        audioBookSaver.saveAudioBooks(audioBooks, "test-audiobooks.csv");

        // Assert
        var expected = """
                999-9-9999-9999-9,The Shining,Stephen King,360,4
                """;

        var actual = Files.readString(Path.of("test-audiobooks.csv")).replace("\r\n", "\n");
        assertEquals(expected, actual);
    }
}