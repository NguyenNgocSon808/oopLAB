package hust.soict.hedspi.aims.comparator;

import java.util.Comparator;
import hust.soict.hedspi.aims.media.*;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int costCompare = Float.compare(m2.getCost(), m1.getCost()); 
        if (costCompare != 0) return costCompare;
        return m1.getTitle().compareTo(m2.getTitle()); 
    }
}
