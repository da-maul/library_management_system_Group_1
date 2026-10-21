public class Movie extends Resource {
    private final String director;
    private final int lengthInMinutes;
    private final long EAN;

    public Movie(String studio, String title, long EAN, String director, int lengthInMinutes,long identifier) {
        super(studio, title, identifier);
        this.director = director;
        this.lengthInMinutes = lengthInMinutes;
        this.EAN = EAN;
    }

    public String getDirector() {return director;}
    public int getLengthInMinutes() {return lengthInMinutes;}
}
