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

public class E1 {

    static Map<LocalDate, String> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String temp = null;

            List<String> regexes = Arrays.asList(
                    "[0-9]{2}/[0-9]/[0-9]",
                    "[0-9]{2}/[0-9]+/[0-9]+",
                    "[0-9]{4}/[0-9]/[0-9]",
                    "[0-9]{4}/[0-9]+/[0-9]+",

                    "[0-9]{2}-[0-9]-[0-9]",
                    "[0-9]{2}-[0-9]+-[0-9]+",
                    "[0-9]{4}-[0-9]-[0-9]",
                    "[0-9]{4}-[0-9]+-[0-9]+",

                    "[0-9]{2}년[0-9]월[0-9]일",
                    "[0-9]{2}년[0-9]+월[0-9]+일",
                    "[0-9]{4}년[0-9]월[0-9]일",
                    "[0-9]{4}년[0-9]+월[0-9]+일"
            );

            List<String> formats = Arrays.asList(
                    "yy/M/d",
                    "yy/MM/dd",
                    "yyyy/M/d",
                    "yyyy/MM/dd",

                    "yy-M-d",
                    "yy-MM-dd",
                    "yyyy-M-d",
                    "yyyy-MM-dd",

                    "yy년M월d일",
                    "yy년MM월dd일",
                    "yyyy년M월d일",
                    "yyyy년MM월dd일"
            );

            List<Pattern> pattern = regexes.stream()
                    .map(Pattern::compile)
                    .collect(Collectors.toList());

            while(!"END".equals((temp = br.readLine()))){
                int target = 0;
                String date = null;

                for(int i = 0; i < regexes.size(); i++){
                    Matcher matcher = pattern.get(i).matcher(temp);

                    if(matcher.find()){
                        target = i;
                        date = matcher.group();
                        break;
                    }
                }

                LocalDate time = LocalDate.parse(
                        date,
                        DateTimeFormatter.ofPattern(formats.get(target))
                );

                memo.put(time, temp);
            }

            StringBuilder sb = new StringBuilder();

            memo.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .map(e -> e.getValue())
                    .forEach(s -> sb.append(s).append("\n"));

            System.out.println(sb.toString());
        }
    }
}
