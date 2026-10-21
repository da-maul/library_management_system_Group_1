import java.time.LocalDate;
import java.util.Objects;

public class Book extends Resource {
    private final String author;
    private final String ISBN;
    private final int pages;

    public Book(String author, String title, String ISBN, int identifier, int pages) {
        super(identifier, title);
        this.author = author;
        this.ISBN = ISBN;
        this.pages = pages;
    }

    public String getAuthor() {return author;}
    public String getISBN() {return ISBN;}
    public int getPages() {return pages;}

    @Override
    public String toString() {
        return String.format("%s by %s, ISBN: %s, ID: %d.", getTitle(), author, ISBN, getIdentifier());
    }
}
