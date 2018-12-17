package teco.exam2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam09 {

    public static String[] insert(String[] a, int index, String s) {
        List<String> list = new ArrayList<>(Arrays.asList(a));
        list.add(index, s);

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] a = {"a", "c", "d", "f", "g", "h"};
        a = insert(a, 1, "b");
        a = insert(a, 4, "e");
        System.out.println(Arrays.toString(a));
    }
}

