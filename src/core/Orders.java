package core;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Service> orders = new ArrayList<>();

    List<Service> getOrders() {
        return orders;
    }

    public void add(Service order) {
        orders.add(order);
    }

    //SORTING
    public void volSort(SortParameters parameter) {
        if (parameter.equals(SortParameters.ASC)) {
            orders.sort(new VolComparator());
        } else {
            orders.sort(new VolComparator().reversed());
        }
    }

    public void dateSort(SortParameters parameter) {
        if (parameter.equals(SortParameters.ASC)) {
            orders.sort(new DateComparator());
        } else {
            orders.sort(new DateComparator().reversed());
        }
    }

    public void sumSort(SortParameters parameter) {
        if (parameter.equals(SortParameters.ASC)) {
            orders.sort(new SumComparator());
        } else {
            orders.sort(new SumComparator().reversed());
        }
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders=" + orders +
                '}';
    }
}
