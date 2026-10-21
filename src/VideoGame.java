public class VideoGame extends Resource {
    private final String platform;
    private final String studio;
    private final long EAN;

    public VideoGame(String studio, String title, long EAN, String platform, long identifier) {
        super(studio, title, identifier);
        this.platform = platform;
        this.EAN = EAN;
        this.studio = studio;
    }

    public String getPlatform() {return platform;}
}
