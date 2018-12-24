package teco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test2 {

}

class Game {
    private Map<Coordinate, Territory> map = new HashMap<>();

    public Game() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(br.readLine());

            for(int row = 0; row < n; row++){
                String[] cols = br.readLine().split(" ");

                for(int col = 0; col < n; col++){
                    Coordinate coordinate = new Coordinate(row, col);
                    if(Character.isAlphabetic(cols[col].charAt(0)))
                        map.put(coordinate, new Territory(coordinate, cols[col]));
                    else
                        map.put(coordinate, new Territory(coordinate, Integer.parseInt(cols[col])));
                }
            }
        }
    }


}

class Territory {
    public static final String NONE = "NONE";

    private String owner = NONE;
    private Coordinate position;

    private static final int[] values = {1, 2, 4, 8};
    private static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    private boolean[] obstacles = new boolean[4];

    public Territory(Coordinate position, String owner) {
        this.position = position;
        this.owner = owner;

        for(int i = 3; i >= 0; i++){
            obstacles[i] = true;
        }
    }

    public Territory(Coordinate position, int obstacle) {
        this.position = position;

        for(int i = 3; i >= 0; i++){
            if(obstacle - values[i] >= 0){
                obstacle -= values[i];
                obstacles[i] = true;
            }
        }
    }

    public Coordinate getPosition() {
        return position;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean canGoToUp(){
        return this.obstacles[UP];
    }

    public boolean canGoToDown(){
        return this.obstacles[DOWN];
    }

    public boolean canGoToLeft(){
        return this.obstacles[LEFT];
    }

    public boolean canGoToRight(){
        return this.obstacles[RIGHT];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Territory territory = (Territory) o;
        return position.equals(territory.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}