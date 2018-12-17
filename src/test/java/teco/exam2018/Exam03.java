package teco.exam2018;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam03 {

    public static void solution(String s) {
        String regex = "[0-9]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        String s = "a1223 (235) 157, 7814; asd_32as";
        solution(s);
    }
}
