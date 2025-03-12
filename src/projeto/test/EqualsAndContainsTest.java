package projeto.test;

import java.util.Arrays;

public class EqualsAndContainsTest {
    public static void main(String[] args) {
        String x = "6.0 anos";
        String y = "6.0";
        String z = "6.0 anos";
        System.out.println(x.toUpperCase().contains(y.toUpperCase()));
        System.out.println(x.contains(z));

        String[] xa = {"1","2","3","4"};
        String[] xb = {"1","2","3","5"};
        System.out.println(Arrays.equals(xa, xb));
    }
}
