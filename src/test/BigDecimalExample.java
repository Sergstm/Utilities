package test;

import java.math.BigDecimal;

public class BigDecimalExample {
    public static void main(String[] args) {

        String str1 = "15.55";
        String str2 = "5.35";

        BigDecimal num1 = new BigDecimal(str1);
        BigDecimal num2 = new BigDecimal(str2);

        BigDecimal sum = num1.add(num2);
        System.out.println(sum);

        BigDecimal sub = num1.subtract(num2);
        System.out.println(sub);

        BigDecimal mult = num1.multiply(num2);
        System.out.println(mult);

        BigDecimal div = num1.divide(num2, 3, BigDecimal.ROUND_HALF_UP);
        System.out.println(div);

        System.out.println(num1.compareTo(num2));
        System.out.println(num1.signum());
    }
}
