package test.reader;

import main.reader.MyReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MyReaderTest {

    @Test
    public void readTest(){

        int i = MyReader.read(br -> {
            return Integer.valueOf(br.readLine());
        });

        Assertions.assertEquals(1, i);
    }
}
