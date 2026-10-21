public class Resource {
    private final long identifier;
    private final String title;
    private final String creator;

    public Resource(String creator, String title, long identifier) {
        this.identifier = identifier;
        this.title = title;
        this.creator = creator;
    }

    public long getIdentifier() {return identifier;}
    public String getTitle() {return title;}
    public String getCreator() {return creator;}
}
