public class Book extends Resource {
    private final int pages;
    private final String ISBN;

    public Book(String author, String title, String ISBN, int pages, int identifier) {
        super(author, title, identifier);
        this.pages = pages;
        this.ISBN = ISBN;
    }

    public int getPages() {return pages;}
    public String getISBN() {return ISBN;}

    @Override
    public boolean equals(Object maybeBook) {
        if (maybeBook instanceof Book otherBook){
            return (getCreator().equals(otherBook.getCreator()) &&
                    getTitle().equals(otherBook.getTitle()) &&
                    getIdentifier() == otherBook.getIdentifier() &&
                    pages == otherBook.pages &&
                    ISBN.equals(otherBook.ISBN));
        }
        else {return false;}
    }

    @Override
    public String toString() {
        return String.format("%s by %s, ISBN: %d. id: %d", getTitle(), getCreator(), ISBN, getIdentifier());
    }
}
