package core;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        Orders orders = new Orders();
        orders.add(getHot());
        orders.add(getCold());
        orders.add(getElectricity());
        orders.add(getHeating());

        orders.volSort(SortParameters.ASC);
        orders.volSort(SortParameters.DESC);

        orders.dateSort(SortParameters.ASC);
        orders.dateSort(SortParameters.DESC);

        orders.sumSort(SortParameters.ASC);
        orders.sumSort(SortParameters.DESC);

        orders.volFilter(new BigDecimal("1"), new BigDecimal("300"));
        LocalDateTime from = LocalDateTime.parse("2018-01-06");
        LocalDateTime to = LocalDateTime.parse("2018-01-12");
        orders.dateFilter(from, to);
        orders.sumFilter(new BigDecimal("10"), new BigDecimal("100"));

        orders.getOrders().stream()
                .map(order -> "Date " + order.getDate()
                        .format(DateTimeFormatter.ofPattern("y-MM-dd HH:mm:ss"))
                        + "Volume" + order.getVolume()
                        + "Sum " + order.getSum())
                .forEach(System.out::println);
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