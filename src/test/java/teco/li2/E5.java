package teco.li2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class E5 {
    static int N;
    static int M;
    static String[][] map;
    static boolean[][] memo;

    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            M = Integer.parseInt(tokenizer.nextToken());

            map = new String[N][];
            memo = new boolean[N][M];

            for(int i = 0 ; i < N; i++)
                map[i] = br.readLine().trim().split("");

            LinkedList<Box> queue = new LinkedList<>();

            Box b = null;

            queue.add(new Box(0, 0, 0, 0));

            while(!queue.isEmpty()){
                b = queue.pop();

                int x = b.x, y = b.y, len = b.len, incount = b.count;

                if(y == map.length - 1 && x == map[0].length - 1)
                    break;

                if(!checkMove(x, y))
                    continue;

                if("H".equals(map[y][x]) && ++incount == 2)
                    continue;

                if(memo[y][x])
                    continue;
                else
                    memo[y][x] = true;

                queue.add(new Box(x + 1, y, len + 1, incount));
                queue.add(new Box(x, y + 1, len + 1, incount));
                queue.add(new Box(x - 1, y, len + 1, incount));
                queue.add(new Box(x, y - 1, len + 1, incount));
            }

            int ans = b.len;

            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
    }

    public static boolean checkMove(int x, int y){
        if(x >= map[0].length || y >= map.length)
            return false;
        else if(x < 0 || y < 0)
            return false;
        else
            return !"M".equals(map[y][x]);
    }

    static class Box{
        int x, y;
        int len, count;

        public Box(int x, int y, int len, int count) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.count = count;
        }
    }
}
