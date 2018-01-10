package core;

import java.util.Comparator;

public class SumComparator implements Comparator<Service> {

    @Override
    public int compare(Service a, Service b) {
        return a.getSum().compareTo(b.getSum());
    }
}
