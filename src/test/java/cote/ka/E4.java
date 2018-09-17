package cote.ka;

import main.reader.MyReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class E4 {
    public static void main(String[] args){

    }
}
class Solution {
    public int solution(int[] food_times, long k) {
        int size = food_times.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < food_times.length; i++) {
            min = Math.min(food_times[i], min);
            max = Math.max(food_times[i], max);
        }

        if(max * size <= k) return -1;

        while(min * size <= k){
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            for(int i = 0; i < food_times.length; i++){
                if(food_times[i] == 0) continue;
                min = Math.min(food_times[i], min);
                max = Math.max(food_times[i], max);
            }

            if(max * size <= k) return -1;
            k -= min * size;

            for(int i = 0; i < food_times.length; i++){
                if(food_times[i] == 0) continue;
                food_times[i] -= min;
                if(food_times[i] == 0) size--;
            }
        }

        int i;

        for(i = 0; i < food_times.length; i++){

            if(food_times[i] == 0) continue;
            if(k-- == 0) break;

            if(i + 1 == food_times.length) i = -1;
        }

        return i + 1;
    }
}