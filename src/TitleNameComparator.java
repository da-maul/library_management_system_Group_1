import java.util.Comparator;

public class TitleNameComparator implements Comparator<Resource> {

    @Override
    public int compare(Resource rsc1, Resource rsc2) {
        return rsc1.getTitle().compareTo(rsc2.getTitle());
    }
}
