package teco.exam2018;

import java.util.Arrays;

public class Exam08 {

    public static void insert(String[] a, int index, String s) {
        for(int i = a.length - 2; i >= index; i--)
            a[i+1] = a[i];

        a[index] = s;
    }

    public static void main(String[] args) {
        String[] a = {"a", "c", "d", "f", "g", "h"};
        insert(a, 1, "b");
        insert(a, 4, "e");
        System.out.println(Arrays.toString(a));
    }
}

