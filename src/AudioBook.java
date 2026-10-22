public class AudioBook extends Resource {
    private final String author;
    private final int lengthInMinutes;
    private final long ISBN;

    public AudioBook(String author, String title, int lengthInMinutes,long ISBN,int identifier) {
        super(author, title,identifier);
        this.author = author;
        this.lengthInMinutes = lengthInMinutes;
        this.ISBN = ISBN;
    }

    public String getAuthor() {return author;}
    public int getLengthInMinutes() {return lengthInMinutes;}
}
