package core;

import java.util.Comparator;

public class VolComparator implements Comparator<Service> {

    @Override
    public int compare(Service a, Service b) {
        return a.getVolume().compareTo(b.getVolume());
    }
}
