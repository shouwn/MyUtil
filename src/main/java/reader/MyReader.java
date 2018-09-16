package reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyReader {
    @FunctionalInterface
    public interface ThrowingFunction<T, R, E extends Exception>{
        R apply(T t) throws E;
    }

    public static <R> R read(ThrowingFunction<BufferedReader, R, Exception> function){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            return function.apply(br);
        } catch (Exception e) {throw new RuntimeException(e);}
    }
}