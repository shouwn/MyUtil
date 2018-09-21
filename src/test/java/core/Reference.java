package core;

import org.junit.Test;

import java.util.Arrays;

public class Reference {

    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(Tester.class.getDeclaredMethod("test"));
    }

    static class Tester{
        int id;

        public void test(){

        }
    }
}
