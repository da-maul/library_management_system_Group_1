public class Movie extends Resource {
    private final String director;
    private final int lengthInMinutes;
    private final long EAN;

    public Movie(String studio, String title, long EAN, String director, int lengthInMinutes,int identifier) {
        super(studio, title, identifier);
        this.EAN = EAN;
        this.director = director;
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getDirector() {return director;}
    public int getLengthInMinutes() {return lengthInMinutes;}

    @Override
    public boolean equals(Object maybeMovie) {
        if (maybeMovie instanceof Movie otherMovie){
            return (getCreator().equals(otherMovie.getCreator()) &&
                    getTitle().equals(otherMovie.getTitle()) &&
                    getIdentifier() == otherMovie.getIdentifier() &&
                    director.equals(otherMovie.director) &&
                    lengthInMinutes == otherMovie.lengthInMinutes &&
                    EAN == otherMovie.EAN);
    }
        else {return false;}
    }

}
