package core;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Orders orders = new Orders();
        orders.add(getHot());
        orders.add(getCold());
        orders.add(getElectricity());
        orders.add(getHeating());

        //Sort
//        orders.volSort(SortParameters.ASC);
//        orders.volSort(SortParameters.DESC);

//        orders.dateSort(SortParameters.ASC);
        orders.dateSort(SortParameters.DESC);   //Default sort

//        orders.sumSort(SortParameters.ASC);
//        orders.sumSort(SortParameters.DESC);

        //Filter
//        List<Service> filtering = orders.volFilter("1", "10");
//        List<Service> filtering = orders.dateFilter("2018-01-06", "2018-01-16");
//        List<Service> filtering = orders.sumFilter("10", "100");

        List<Service> filtering = orders.getOrders();   //Default filter

        //Out
        filtering.stream()
                .map(Main::printOrders)
                .forEach(System.out::println);
    }

    private static String printOrders(Service service) {
        return "Date: " + service.getDate()
                .format(DateTimeFormatter.ofPattern("y-MM-dd HH:mm:ss"))
                + "\tVolume= " + service.getVolume()
                + "\tSum= " + service.getSum();
    }

    private static Service getHot() {
        BigDecimal prev = new BigDecimal("10");
        BigDecimal pres = new BigDecimal("15");
        BigDecimal tariffIn = new BigDecimal("84.45");
        return new EasyService(prev, pres, tariffIn);
    }

    private static Service getCold() {
        BigDecimal prev = new BigDecimal("10");
        BigDecimal pres = new BigDecimal("18");
        BigDecimal tariffIn = new BigDecimal("8.436");
        return new EasyService(prev, pres, tariffIn);
    }

    private static Service getElectricity() {
        BigDecimal prev = new BigDecimal("150");
        BigDecimal pres = new BigDecimal("251");
        BigDecimal tariff1 = new BigDecimal("0.9");
        BigDecimal tariff2 = new BigDecimal("1.68");
        return new HardService(prev, pres, tariff1, tariff2);
    }

    private static Service getHeating() {
        BigDecimal prev = new BigDecimal("0");
        BigDecimal pres = new BigDecimal("0.8");
        BigDecimal tariffIn = new BigDecimal("1414.45");
        return new EasyService(prev, pres, tariffIn);
    }
}