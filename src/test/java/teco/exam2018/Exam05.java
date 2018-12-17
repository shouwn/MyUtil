package teco.exam2018;

import java.util.*;

public class Exam05 {

    public static List<String> union(String[] a1, String[] a2) {
        Set<String> set1 = new HashSet<String>(Arrays.asList(a1));
        Set<String> set2 = new HashSet<String>(Arrays.asList(a2));

        set1.addAll(set2);

        return new ArrayList<>(set1);
    }

    public static void main(String[] args) {
        String[] a1 = { "a", "d", "a", "b", "b", "c" };
        String[] a2 = { "c", "a", "e", "f", "b", "g" };
        List<String> list = union(a1, a2);
        System.out.println(list.toString());
    }
}

