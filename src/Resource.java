public class Resource {
    //why in the fuck was identifier a long before
    private final int identifier;
    private final String title;
    private final String creator;

    public Resource(String creator, String title, int identifier) {
        this.identifier = identifier;
        this.title = title;
        this.creator = creator;
    }

    public int getIdentifier() {return identifier;}
    public String getTitle() {return title;}
    public String getCreator() {return creator;}
}
