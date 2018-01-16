package core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Service> volFilter(String from, String to) {
        BigDecimal fromVol = new BigDecimal(from);
        BigDecimal toVol = new BigDecimal(to);
        return orders.stream()
                .filter(order -> order.getVolume().compareTo(fromVol) > 0)
                .filter(order -> order.getVolume().compareTo(toVol) < 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Service> dateFilter(String from, String to) {
        LocalDateTime fromDate = LocalDateTime.parse(from.concat("T00:00:00"));
        LocalDateTime toDate = LocalDateTime.parse(to.concat("T23:59:59"));
        return orders.stream()
                .filter(order -> order.getDate().compareTo(fromDate) > 0)
                .filter(order -> order.getDate().compareTo(toDate) < 0)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public List<Service> sumFilter(String from, String to) {
        BigDecimal fromSum = new BigDecimal(from);
        BigDecimal toSum = new BigDecimal(to);
        return orders.stream()
                .filter(order -> order.getSum().compareTo(fromSum) > 0)
                .filter(order -> order.getSum().compareTo(toSum) < 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders=" + orders +
                '}';
    }
}
