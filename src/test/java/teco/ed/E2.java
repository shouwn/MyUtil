package teco.ed;

public class E2 {

}

class Solution2 {
    private boolean[][] map = new  boolean[21][21];

    private static final char UP = 'U', DOWN = 'D', RIGHT = 'R', LEFT = 'L';

    private int count = 0;

    public int solution(String dirs) {
        int x = 0, y = 0;

        for(int order = 0; order < dirs.length(); order++){
            System.out.println("x: " + x +" " + "y: " + y + " move: " + dirs.charAt(order));
            int calX = calX(x), calY = calY(y);

            switch (dirs.charAt(order)){
                case UP:
                    if(y < 5) {
                        y++;
                        this.checking(calX, calY - 1);
                    }
                    break;
                case DOWN:
                    if(y > -5) {
                        y--;
                        this.checking(calX, calY + 1);
                    }
                    break;
                case RIGHT:
                    if(x < 5) {
                        x++;
                        this.checking(calX + 1, calY);
                    }
                    break;
                case LEFT:
                    if(x > -5) {
                        x--;
                        this.checking(calX - 1, calY);
                    }
                    break;
            }
        }

        return count;
    }

    private int calX(int position){
        return (5 + position) * 2;
    }

    private int calY(int position){
        return (5 - position) * 2;
    }

    private void checking(int x, int y){
        System.out.println("x: " + x +" " + "y: " + y);

        if(!map[y][x]) {
            map[y][x] = true;
            count++;
        }
    }
}