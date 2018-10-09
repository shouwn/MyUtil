package teco.li2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1 {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            String ip = scanner.nextLine();

            int size = ip.length();

            List<String> ans = new ArrayList<>();

            for(int i = 1; i <= 3; i++){

                int numI = cal(0, i, size, ip);

                if(numI > 255)
                    continue;

                for(int j = 1; j <= 3; j++){
                    int numJ = cal(i, j, size, ip);

                    if(numJ > 255)
                        continue;

                    for(int w = 1; w <= 3; w++){
                        int numW = cal(i + j, w, size, ip);

                        if(numW > 255)
                            continue;

                        for(int k = 1; k <= 3; k++){
                            if(i + j + w + k != size)
                                continue;

                            int numK = cal(i + j + w, k, size, ip);

                            if(numK > 255)
                                continue;

                            ans.add(new StringBuilder()
                                    .append(numI)
                                    .append(".")
                                    .append(numJ)
                                    .append(".")
                                    .append(numW)
                                    .append(".")
                                    .append(numK)
                                    .toString());
                        }
                    }
                }
            }

            StringBuilder sb=  new StringBuilder();

            ans.stream()
                    .sorted()
                    .forEach(s -> sb.append(s).append("\n"));

            System.out.println(sb.toString());

        }
    }

    public static int cal(int begin, int value, int size, String ip){
        if(begin + value > size)
            return Integer.MAX_VALUE;

        String sub = ip.substring(begin, begin + value);

        if(sub.length() > 1 && sub.charAt(0) == '0')
            return Integer.MAX_VALUE;

        int num = Integer.parseInt(sub);

        if(num > 255)
            return Integer.MAX_VALUE;

        return num;
    }
}

