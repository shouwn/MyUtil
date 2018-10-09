package teco.li2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E4 {
    static int N;
    static int M;
    static String[][] map;
    static boolean[][][] memo;
    static int[][][] minMemo;

    static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            M = Integer.parseInt(tokenizer.nextToken());

            map = new String[N][];
            memo = new boolean[N][M][4];
            minMemo = new int[N][M][4];

            for(int i = 0 ; i < N; i++)
                map[i] = br.readLine().trim().split("");

            memo[0][0][UP] = true;
            memo[0][0][LEFT] = true;
            memo[0][0][RIGHT] = true;

            int ans = solution(0, 0, 0, 0, DOWN);

            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
    }

    public static int solution(int incount, int x, int y, int len, int before){

        if(y == map.length - 1 && x == map[0].length - 1)
            return len;

        if(!checkMove(x, y))
            return Integer.MAX_VALUE;

        if("H".equals(map[y][x]) && ++incount == 2)
            return Integer.MAX_VALUE;

        if(memo[y][x][before])
            return Integer.MAX_VALUE;
        else
            memo[y][x][before] = true;

        int min = Integer.MAX_VALUE;
        len++;

        min = Math.min(min, solution(incount, x - 1, y, len, LEFT));
        min = Math.min(min, solution(incount, x, y - 1, len, UP));
        min = Math.min(min, solution(incount, x + 1, y, len, RIGHT));
        min = Math.min(min, solution(incount, x, y + 1, len, DOWN));

//        System.out.println(x + " " + y + " " + len);

        return min;
    }

    public static boolean checkMove(int x, int y){
        if(x >= map[0].length || y >= map.length)
            return false;
        else if(x < 0 || y < 0)
            return false;
        else
            return !"M".equals(map[y][x]);
    }
}
