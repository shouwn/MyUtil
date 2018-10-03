package teco.ka;

import utils.reader.MyReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class E5 {
    public static void main(String[] args){

    }

    @FunctionalInterface
    public interface ThrowingFunction<T, R, E extends Exception>{
        R apply(T t) throws E;
    }

    public static <R> R read(MyReader.ThrowingFunction<BufferedReader, R, Exception> function){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            return function.apply(br);
        } catch (Exception e) {throw new RuntimeException(e);}
    }
}
