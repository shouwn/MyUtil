package teco.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class E3 {

    static int reach = 0;

    static final int X = 0, Y = 1;

    static int[][] canMove = new int[][]{
            {-2, -1},
            {-1, -2},
            {1, -2},
            {2, -1},
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1}
    };

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] s = br.readLine().trim().split(" ");

            boolean[][] map = new boolean[Integer.parseInt(s[1])][Integer.parseInt(s[0])];

            Box b = solution(map);

            System.out.println(b.result + b.count);
        }
    }

    public static Box solution(boolean[][] map){
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0, 0));

        int count = 0;
        boolean reach = false;
        int depth = 0;

        while(!queue.isEmpty()){
            Point cur = queue.poll();

            if(map[cur.y][cur.x])
                continue;

            depth = Math.max(depth, cur.depth);

            map[cur.y][cur.x] = true;
            count++;

            if(count == map.length * map[0].length){
                reach = true;
                break;
            }

            for(int i = 0; i < canMove.length; i++){
                int x = cur.x + canMove[i][X];
                int y = cur.y + canMove[i][Y];

                if(checkOut(map, x, y))
                    queue.add(new Point(x, y, cur.depth + 1));
            }
        }

        return reach ? Box.reach(depth) : Box.unReach(depth);
    }

    public static boolean checkOut(boolean[][] map, int x, int y){
        if(map.length <= y) return false;
        if(map[0].length <= x) return false;

        return y >= 0 && x >= 0;
    }

    static class Point{
        int x, y;
        int depth;

        public Point(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    static class Box{
        String result;
        int count;

        public static Box reach(int count){
            Box b = new Box();
            b.result = "T"; b.count = count;

            return b;
        }

        public static Box unReach(int count){
            Box b = new Box();
            b.result = "F"; b.count = count;

            return b;
        }
    }
}
