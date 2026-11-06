import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanSaverTest {
    @Test
    void testSaveLoans() throws IOException {
        // Arrange
        var joe = new Member("Joe Mama", 1337);
        var book1 = new Book("Allan B. Downey", "Think Java", "978-1-4028-9462-6", 324, 1);

        var loans = List.of(
                new Loan(book1, joe, LocalDate.parse("2024-01-01"), LocalDate.parse("2026-01-31"))
        );
        var loanSaver = new LoanSaver();

        // Act
        loanSaver.saveLoans(loans, "test-loans.csv");

        // Assert
        var expected = """
                1337,978-1-4028-9462-6,2024-01-01,2026-01-31
                """;

        var actual = Files.readString(Path.of("test-loans.csv")).replace("\r\n", "\n");
        assertEquals(expected, actual);
    }
}