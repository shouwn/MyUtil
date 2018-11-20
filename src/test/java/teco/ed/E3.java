package teco.ed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class E3 {
    public static void main(String[] args){
        Stream.iterate(2, n -> n + 1).limit(8)
                .flatMap(n -> Stream.iterate(1, r -> r + 1).limit(9)
                        .map(r -> n + " * " + r + " = " + n * r))
                .forEach(System.out::println);
    }
}

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;

        Queue<Integer> queueL = new LinkedList<>();
        Queue<Integer> queueR = new LinkedList<>();

        int leftSum = cookie[0], rightSum = 0;

        new ArrayList<Integer>().toArray(new Integer[0]);

        queueL.add(cookie[0]);

        for(int i = 1; i < cookie.length; i++){
            queueR.add(cookie[i]);
            while(!queueR.isEmpty() && leftSum < rightSum){
                int tmp = queueR.poll();
                queueL.add(tmp);
                leftSum += tmp;
            }
            if(leftSum == rightSum)
                answer = Math.max(answer, leftSum);
        }

        return answer;
    }
}

class Solution4 {
    public int solution(int[] cookie) {
        int answer = 0;

        for(int leftF = 0; leftF < cookie.length; leftF++){
            int leftSum = 0;

            for(int leftR = leftF; leftR < cookie.length; leftR++){
                leftSum += cookie[leftR];

                int rightSum = 0;

                for(int rightR = leftR + 1; rightR < cookie.length; rightR++){
                    rightSum += cookie[rightR];
                    while(leftR < rightR && leftSum < rightSum){
                        leftSum += cookie[++leftR];
                        rightSum -= cookie[leftR];
                    }
                    if(leftSum == rightSum){
//                        System.out.printf("lf: %d, lr: %d, rr: %d", leftF, leftR, rightR);
                        answer = Math.max(leftSum, answer);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}

class Solution3 {
    public int solution(int[] cookie) {
        int answer = 0;

        for(int leftF = 0; leftF < cookie.length; leftF++){
            int leftSum = 0;

            for(int leftR = leftF; leftR < cookie.length; leftR++){
                leftSum += cookie[leftR];

                int rightSum = 0;

                for(int rightR = leftR + 1; rightR < cookie.length && leftSum > rightSum; rightR++){
                    rightSum += cookie[rightR];
                    if(leftSum == rightSum){
//                        System.out.printf("lf: %d, lr: %d, rr: %d", leftF, leftR, rightR);
                        answer = Math.max(leftSum, answer);
                        break;
                    }
                }
            }
        }
        return answer;
    }

}