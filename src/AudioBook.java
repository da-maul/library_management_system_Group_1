public class AudioBook extends Resource {
    private final String author;
    private final int lengthInMinutes;

    public AudioBook(String author, String title, long ISBN, int lengthInMinutes) {
        super(author, title, ISBN);
        this.author = author;
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getAuthor() {return author;}
    public int getLengthInMinutes() {return lengthInMinutes;}
}
