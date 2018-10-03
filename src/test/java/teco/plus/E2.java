package teco.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E2 {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int m = Integer.parseInt(br.readLine().trim());

            if(m < 1 || m > 8) {
                System.out.println(-1);
                return;
            }

            List<Integer> max = Arrays.stream(br.readLine().trim().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            max.add(0);

            if(Collections.max(max) > 9 || Collections.min(max) < 0){
                System.out.println(-1);
                return;
            }

            List<Integer> cur = Arrays.stream(br.readLine().trim().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            cur.add(0);

            for(int i = 0; i < max.size() - 1; i++){
                if(cur.get(i) < 0 || cur.get(i) > max.get(i)){
                    System.out.println(-1);
                    return;
                }
            }

            int push = Integer.parseInt(br.readLine().trim());

            int[] values = new int[m + 1];
            values[m] = 1;

            for(int i = m - 1; i >= 0; i--)
                values[i] = values[i + 1] * (max.get(i + 1) + 1);

            StringBuilder sb = new StringBuilder();

            int value = 0;

            for(int i = 0; i < m; i++)
                value += values[i] * cur.get(i);

            value += push;

            for(int i = 0; i < m; i++){
                int temp = value / values[i];
                if(temp > max.get(i)) temp = 0;
                value %= values[i];
                sb.append(temp);
            }

            System.out.println(sb.toString());
        }
    }
}
