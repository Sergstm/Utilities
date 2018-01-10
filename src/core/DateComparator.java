package core;

import java.util.Comparator;

public class DateComparator implements Comparator<Service> {

    @Override
    public int compare(Service a, Service b) {
        return a.getDate().compareTo(b.getDate());
    }
}
