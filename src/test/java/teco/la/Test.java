package teco.la;

import java.util.Arrays;

public class Test {

    public static void main(String[] args){

        String s = "/users/CONY";

        System.out.println(s.matches(".+/data"));

        s = "value=TEST_DATA";

        System.out.println(s.substring(6));

        s = "/users/CONY/data";

        System.out.println(Arrays.toString(s.split("/")));
    }
}
