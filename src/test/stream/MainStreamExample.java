package test.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainStreamExample {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("j");
        list.add("a");
        list.add("v");
        list.add("a");

//        System.out.println(list);

        list.stream()
                .filter(p -> p.contains("a"))
                .sorted()
                .forEach(System.out::println);
    }


}
