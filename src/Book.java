import java.time.LocalDate;
import java.util.Objects;

public record Book(String author, String title, String ISBN, int ID) {
    @Override
    public String toString() {
        return String.format("%s by %s, ISBN: %s, ID: %d.", title, author, ISBN, ID);
    }
}
