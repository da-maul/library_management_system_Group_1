public class VideoGame extends Resource {
    private final String platform;
    private final String studio;
    private final long EAN;

    public VideoGame(String studio, String title, long EAN, String platform, int identifier) {
        super(studio, title, identifier);
        this.platform = platform;
        this.EAN = EAN;
        this.studio = studio;
    }

    public String getPlatform() {return platform;}

    @Override
    public boolean equals(Object maybeGame) {
        if (maybeGame instanceof VideoGame otherGame){
            return (getCreator().equals(otherGame.getCreator()) &&
                    getTitle().equals(otherGame.getTitle()) &&
                    getIdentifier() == otherGame.getIdentifier() &&
                    platform.equals(otherGame.platform) &&
                    EAN == otherGame.EAN &&
                    studio.equals(otherGame.studio)
                    );
        }
        else {return false;}
    }
}
