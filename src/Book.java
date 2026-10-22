public class Book extends Resource {
    private final int pages;
    private final long ISBN;

    public Book(String author, String title, long ISBN, int pages, int identifier) {
        super(author, title, identifier);
        this.pages = pages;
        this.ISBN = ISBN;
    }

    public int getPages() {return pages;}

    @Override
    public String toString() {
        return String.format("%s by %s, ISBN: %d. id: %d", getTitle(), getCreator(), ISBN, getIdentifier());
    }
}
