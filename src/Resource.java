public class Resource {
    private final int identifier;
    private final String title;

    public Resource(int identifier, String title) {
        this.identifier = identifier;
        this.title = title;
    }

    public int getIdentifier() {return identifier;}
    public String getTitle() {return title;}
}
