public class AudioBook extends Resource {
    private final String author;
    private final int lengthInMinutes;
    private final String ISBN;

    public AudioBook(String author, String title, int lengthInMinutes, String ISBN, int identifier) {
        super(author, title, identifier);
        this.author = author;
        this.lengthInMinutes = lengthInMinutes;
        this.ISBN = ISBN;
    }

    public String getAuthor() {return author;}
    public int getLengthInMinutes() {return lengthInMinutes;}
    public String getISBN() {return ISBN;}

    @Override
    public boolean equals(Object maybeAudioBook) {
        if (maybeAudioBook instanceof AudioBook otherAudioBook){
            return (getCreator().equals(otherAudioBook.getCreator()) &&
                    getTitle().equals(otherAudioBook.getTitle()) &&
                    getIdentifier() == otherAudioBook.getIdentifier() &&
                    author.equals(otherAudioBook.getCreator()) &&
                    lengthInMinutes == otherAudioBook.lengthInMinutes &&
                    ISBN.equals(otherAudioBook.ISBN));
        }
        else {return false;}
    }
}
