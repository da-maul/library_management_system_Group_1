import java.time.LocalDate;
import java.util.Objects;

public class Book extends Resource {
    private final int pages;

    public Book(String author, String title, long ISBN, int pages) {
        super(author, title, ISBN);
        this.pages = pages;
    }

    public int getPages() {return pages;}

    @Override
    public String toString() {
        return String.format("%s by %s, ISBN: %d.", getTitle(), getCreator(), getIdentifier());
    }
}
