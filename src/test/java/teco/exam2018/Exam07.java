package teco.exam2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam07 {

    public static List<Integer> toList(Integer... a) {
        return Arrays.asList(a);
    }

    public static void main(String[] args) {
        System.out.println(toList(7));
        System.out.println(toList(2, 3, 5));
        System.out.println(toList(7, 3, 4, 5, 6));
    }
}
