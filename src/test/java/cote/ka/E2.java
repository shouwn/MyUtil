package cote.ka;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E2 {

}

//class Solution {
//    public int[] solution(int N, int[] stages) {
//        List<Stage> list = new ArrayList<>();
//
//        for(int i = 0; i <= N + 1; i++)
//            list.add(new Stage(i));
//
//        for(int i = 0; i < stages.length; i++){
//            int until = stages[i];
//
//            for(int j = 0; j < until; j++)
//                list.get(j).add();
//
//            list.get(until).reach++;
//        }
//
//        list.remove(N+1);
//        list.remove(0);
//
//        Collections.sort(list);
//
//        int[] ans = new int[N];
//
//        for(int i = 0; i < list.size(); i++)
//            ans[i] = list.get(i).getId();
//
//        return ans;
//    }
//
//    class Stage implements Comparable<Stage>{
//        int id;
//        int clear;
//        int reach;
//
//        public int getId() {
//            return id;
//        }
//
//        public Stage(int id) {
//            this.id = id;
//        }
//
//        @Override
//        public int compareTo(Stage o) {
//            double thisFailure = this.cal();
//            double oFailure = o.cal();
//
//            if(thisFailure == oFailure)
//                return Integer.compare(this.id, o.id);
//            else
//                return thisFailure - oFailure < 0 ? 1 : -1;
//        }
//
//        public double cal(){
//            if(reach == 0)
//                return 0;
//
//            return ((double) reach - clear) / reach;
//        }
//
//        public void add(){
//            clear++;
//            reach++;
//        }
//    }
//}