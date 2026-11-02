import java.util.Comparator;

public class CreatorNameComparator implements Comparator<Resource> {

    @Override
    public int compare(Resource rsc1, Resource rsc2) {
        return rsc1.getCreator().compareTo(rsc2.getCreator());
    }
}
