public class Movie extends Resource {
    private final String director;
    private final int lengthInMinutes;

    public Movie(String studio, String title, long EAN, String director, int lengthInMinutes) {
        super(studio, title, EAN);
        this.director = director;
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getDirector() {return director;}
    public int getLengthInMinutes() {return lengthInMinutes;}
}
