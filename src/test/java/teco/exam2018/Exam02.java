package teco.exam2018;

import java.util.*;

public class Exam02 {

    public static void solution(List<String> list) {
        Set<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("d", "a", "b", "a", "c", "d", "e", "f", "e"));
        solution(list);
        System.out.println(list);
    }
}
