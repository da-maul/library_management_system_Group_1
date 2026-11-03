import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoGameSaverTest {
    @Test
    void testSaveVideoGames() throws IOException {
        // Arrange
        var games = List.of(
                new VideoGame("Rockstar", "GTA 5", 85566909595L, "PC", 10),
                new VideoGame("Nintendo", "Zelda", 443667L, "Switch", 12)
        );
        var videoGameSaver = new VideoGameSaver();

        // Act
        videoGameSaver.saveVideoGames(games, "test-videogames.csv");

        // Assert
        var expected = """
                Rockstar,GTA 5,85566909595,PC,10
                Nintendo,Zelda,443667,Switch,12
                """;

        var actual = Files.readString(Path.of("test-videogames.csv")).replace("\r\n", "\n");
        assertEquals(expected, actual);
    }
}