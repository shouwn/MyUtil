package teco.exam2018;

import java.util.*;

public class Exam06 {

    public static List<String> intersection(String[] a1, String[] a2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(a1));
        Set<String> set2 = new HashSet<>(Arrays.asList(a2));

        set1.retainAll(set2);

        return new ArrayList<>(set1);
    }

    public static void main(String[] args) {
        String[] a1 = { "a", "d", "a", "b", "b", "c" };
        String[] a2 = { "c", "a", "e", "f", "b", "g" };
        List<String> list = intersection(a1, a2);
        System.out.println(list.toString());
    }
}
