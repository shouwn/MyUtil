package teco.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class E4 {


    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

            List<Integer> cards = Arrays.stream(br.readLine().trim().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            int ans = Integer.parseInt(br.readLine());

            List<List<Integer>> result = new ArrayList<>();

            boolean flag = false;

            for(int i = 0; i < cards.size(); i++){
                for(int j = i + 1; j < cards.size(); j++){
                    for(int w = j + 1; w < cards.size(); w++){
                        if(cards.get(i) + cards.get(j) + cards.get(w) == ans){
                            result.add(Arrays.asList(cards.get(i), cards.get(j), cards.get(w)));
                            flag = true;
                        }
                    }
                }
            }

            if(result.size() == 0){
                System.out.println("NO");
                return;
            }

            StringJoiner stringJoiner = new StringJoiner("\n");

            result.stream()
                    .map(line -> {
                        StringJoiner sj = new StringJoiner(" ");

                        line.stream()
                                .sorted()
                                .map(String::valueOf)
                                .forEach(sj::add);

                        return sj.toString();
                    })
                    .forEach(stringJoiner::add);

            System.out.println(stringJoiner.toString());
        }
    }
}
