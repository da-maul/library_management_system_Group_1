public class VideoGame extends Resource {
    private final String platform;

    public VideoGame(String studio, String title, long EAN, String platform) {
        super(studio, title, EAN);
        this.platform = platform;
    }

    public String getPlatform() {return platform;}
}
