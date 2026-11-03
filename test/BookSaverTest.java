import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookSaverTest {
    @Test
    void testSaveBooks() throws IOException {
        // Arrange
        var books = List.of(
                new Book("Allan B. Downey", "Think Java", "978-1-4028-9462-6", 324, 1),
                new Book("Rachel Cusk", "Omrids", "732-5-2817-4127-6", 240, 2)
        );
        var bookSaver = new BookSaver();

        // Act
        bookSaver.saveBooks(books, "test-books.csv");

        // Assert
        var expected = """
                978-1-4028-9462-6,Think Java,Allan B. Downey,324,1
                732-5-2817-4127-6,Omrids,Rachel Cusk,240,2
                """;

        var actual = Files.readString(Path.of("test-books.csv")).replace("\r\n", "\n");
        assertEquals(expected, actual);
    }
}