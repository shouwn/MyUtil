package teco.li1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E1 {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int round = Integer.parseInt(br.readLine());

            for(int i = 0; i < round; i++){
                int count = Integer.parseInt(br.readLine());

                List<Double> brown = new ArrayList<>();
                List<Double> cony = new ArrayList<>();

                for(int j = 0; j < count; j++){ // 스톤 추가
                    String[] in = br.readLine().split(" ");

                    List<Double> temp;

                    if("Brown".equals(in[2])) temp = brown;
                    else temp = cony;

                    temp.add(Math.sqrt(Math.pow(Double.parseDouble(in[0]), 2) + Math.pow(Double.parseDouble((in[1])), 2)));
                }

                double brownMin = Collections.min(brown);
                double conyMin = Collections.min(cony);

                StringBuilder ans = new StringBuilder();

                int score = 0;

                if(brownMin < conyMin) {
                    ans.append("Brown").append(" ");
                    for(double dis : brown){
                        if(dis < conyMin) score++;
                    }
                }
                else {
                    ans.append("Cony").append(" ");
                    for(double dis : cony){
                        if(dis < brownMin) score++;
                    }
                }
                ans.append(score);

                System.out.println(ans.toString());
            }
        }
    }
}
