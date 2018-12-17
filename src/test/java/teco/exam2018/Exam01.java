package teco.exam2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exam01 {

    public static List<String> solution(List<String> list) {
        return list.stream().distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList("d", "a", "b", "a", "c", "d", "e", "f", "e"));
        List<String> list2 = solution(list1);
        System.out.println(list1);
        System.out.println(list2);
    }
}
