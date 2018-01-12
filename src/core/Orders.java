package core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    //FILTERING
    public void volFilter(BigDecimal from, BigDecimal to) {
        orders.stream()
                .filter(order -> order.getVolume().compareTo(from) > 0)
                .filter(order -> order.getVolume().compareTo(to) < 0)
                .map(Service::getVolume)
                .forEach(System.out::println);
    }

    public void dateFilter(LocalDateTime from, LocalDateTime to) {
        orders.stream()
                .filter(order -> order.getDate().compareTo(from) > 0)
                .filter(order -> order.getDate().compareTo(to) < 0)
                .map(Service::getDate)
                .forEach(System.out::println);
    }

    public void sumFilter(BigDecimal from, BigDecimal to) {
        orders.stream()
                .filter(order -> order.getSum().compareTo(from) > 0)
                .filter(order -> order.getSum().compareTo(to) < 0)
                .map(Service::getSum)
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders=" + orders +
                '}';
    }
}
