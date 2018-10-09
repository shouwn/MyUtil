package teco.li2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E2 {

    public static void main(String[] args) throws IOException, ScriptException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            System.out.println(engine.eval(br.readLine()));
        }
    }
}
