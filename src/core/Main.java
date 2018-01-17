package core;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DataTransfer transfer = new DataTransfer();
        //GET DATA
        List<String> dataList = transfer.getData();

        Orders orders = new Orders();
        //CREATE ORDERS
        orders.add(getHot(dataList));
        orders.add(getCold(dataList));
        orders.add(getElectricity(dataList));
        orders.add(getHeating(dataList));

        //SEND DATA
//        transfer.writeData(orders.getOrders(), false);

        //SORT
//        orders.volSort(SortParameters.ASC);
//        orders.volSort(SortParameters.DESC);
//        orders.dateSort(SortParameters.ASC);
        orders.dateSort(SortParameters.DESC);   //Default sort
//        orders.sumSort(SortParameters.ASC);
//        orders.sumSort(SortParameters.DESC);

        //FILTER
//        List<Service> filtering = orders.volFilter("1", "10");
//        List<Service> filtering = orders.dateFilter("2018-01-06", "2018-01-18");
//        List<Service> filtering = orders.sumFilter("10", "100");
        List<Service> filtering = orders.getOrders();   //Default filter

        //OUT
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

    private static Service getHot(List<String > data) {
        String[] vol = data.get(0).split("---");
        String preview = vol[1];
        String present = vol[2];
        String tariff = vol[3];
        BigDecimal prev = new BigDecimal(preview);
        BigDecimal pres = new BigDecimal(present);
        BigDecimal tariffIn = new BigDecimal(tariff);
        return new EasyService(prev, pres, tariffIn);
    }

    private static Service getCold(List<String > data) {
        String[] vol = data.get(1).split("---");
        String preview = vol[1];
        String present = vol[2];
        String tariff = vol[3];
        BigDecimal prev = new BigDecimal(preview);
        BigDecimal pres = new BigDecimal(present);
        BigDecimal tariffIn = new BigDecimal(tariff);
        return new EasyService(prev, pres, tariffIn);
    }

    private static Service getElectricity(List<String > data) {
        String[] vol = data.get(2).split("---");
        String preview = vol[1];
        String present = vol[2];
        String tar1 = vol[3];
        String tar2 = vol[4];
        BigDecimal prev = new BigDecimal(preview);
        BigDecimal pres = new BigDecimal(present);
        BigDecimal tariff1 = new BigDecimal(tar1);
        BigDecimal tariff2 = new BigDecimal(tar2);
        return new HardService(prev, pres, tariff1, tariff2);
    }

    private static Service getHeating(List<String > data) {
        String[] vol = data.get(3).split("---");
        String preview = vol[1];
        String present = vol[2];
        String tariff = vol[3];
        BigDecimal prev = new BigDecimal(preview);
        BigDecimal pres = new BigDecimal(present);
        BigDecimal tariffIn = new BigDecimal(tariff);
        return new EasyService(prev, pres, tariffIn);
    }
}