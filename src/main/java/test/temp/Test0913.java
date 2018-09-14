package test.temp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Test0913 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < b; i++){

            for(int j = 0; j < a; j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    public static boolean solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i]) || arr[i] > arr.length || arr[i] < 1)
                return false;
            else
                map.put(arr[i], 1);
        }

        return true;
    }
}
