package teco.la;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E2 {

    public static void main(String[] args) throws IOException {
        int[][] bitmap = new int[101][101];

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                int w = Integer.parseInt(tokenizer.nextToken());
                int h = Integer.parseInt(tokenizer.nextToken());

                for(int j = x; j < x + w; j++){
                    for(int l = y; l < j + h; l++){
                        bitmap[j][l]++;
                    }
                }
            }

            int max = Integer.MIN_VALUE;

            for(int i = 0; i <  bitmap.length; i++){
                for(int j = 0; j < bitmap.length; j++){
                    max = Math.max(max, bitmap[i][j]);
                }
            }

            System.out.println(max);
        }
    }
}
