package teco.la;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class E1 {

    public static void main(String[] args) throws IOException {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);

        int use = 0;

        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());

            int pre = use;

            if(distance <= 40)
                use += 720;
            else
                use += (((distance - 40 + 7) / 8) * 80) + 720;

            if(distance < 4 || distance > 178 || use > 20000) {
                use = pre;
                break;
            }
        }

        System.out.println(20000 - use);
    }
}
