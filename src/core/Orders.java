package core;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Service> orders = new ArrayList<>();

    List<Service> getOrders() {
        return orders;
    }

    public void add(Service order) {
        orders.add(order) ;
    }

    public void volSort(SortParameters parameter) {
        if (parameter.compareTo(SortParameters.ASC) == 0) {
            this.getOrders().sort(new VolComparator());
        }
        if (parameter.compareTo(SortParameters.DESC) == 0) {
            this.getOrders().sort(new VolComparator().reversed());
        }
    }

    public void dateSort(SortParameters parameter) {
        if (parameter.compareTo(SortParameters.ASC) == 0) {
            this.getOrders().sort(new DateComparator());
        }
        if (parameter.compareTo(SortParameters.DESC) == 0) {
            this.getOrders().sort(new DateComparator().reversed());
        }
    }

    public void sumSort(SortParameters parameter) {
        if (parameter.compareTo(SortParameters.ASC) == 0) {
            this.getOrders().sort(new SumComparator());
        }
        if (parameter.compareTo(SortParameters.DESC) == 0) {
            this.getOrders().sort(new SumComparator().reversed());
        }
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders=" + orders +
                '}';
    }
}
