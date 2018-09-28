
//
//import main.reader.MyReader;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class E3 {
//    public static void main(String[] args){
//        System.out.println(new Solution().solution(new String[][] {
//                {"100", "ryan", "music", "2"},
//                {"200", "apeach", "math", "2"},
//                {"300", "tube", "computer", "3"},
//                {"400", "con", "computer", "4"},
//                {"500", "muzi", "music", "3"},
//                {"600", "apeach", "music", "2"}
//        }));
//
////        System.out.println(new Solution().combination(Arrays.asList(new Integer[] { 1, 3, 5})));
//    }
//}
//
//class Solution {
//    Map<List<Integer>, Boolean> memo = new HashMap<>();
//
//    Map<Integer, List<List<Integer>>> map = new HashMap<>();
//
//    public int solution(String[][] relation) {
//        List<Integer> col = new ArrayList<>();
//
//        for(int i = 0; i < relation[0].length; i++)
//            col.add(i);
//
//        this.solution(relation, col);
//
//        System.out.println(memo);
//
//        return memo.entrySet().stream()
//                .map(e -> {
//                    if(e.getKey().size() == 1) {
//
//                        return e.getValue() ? 1 : 0;
//                    }
//                    else {
//                        return !this.checkContainsKey(e.getKey()) ? 1 : 0;
//                    }
//                })
//                .reduce((p1, p2) -> p1 + p2).orElse(0);
//    }
//
//    public boolean checkContainsKey(List<Integer> col){
//        if(col.size() == 1)
//            return memo.get(col);
//
//        boolean result = false;
//
//        for(List<Integer> l : this.combination(col)){
//            result = result || memo.get(l);
//
//            if(result) return true;
//        }
//
//        for(List<Integer> l : this.combination(col)){
//            result = result || this.checkContainsKey(l);
//
//            if(result) return true;
//        }
//
//        return !memo.get(col);
//    }
//
//    public void solution(String[][] relation, List<Integer> col){
//        if(memo.containsKey(col))
//            return;
//
//        memo.put(col, this.checkUnique(relation, col));
//
//        if(col.size() > 1)
//            for(List<Integer> l : this.combination(col))
//                solution(relation, l);
//    }
//
//    public List<List<Integer>> combination(List<Integer> col){
//        List<List<Integer>> result = new ArrayList<>();
//
//        List<List<Integer>> combination = this.combination(col.size() - 1);
//
//        for(List<Integer> list : combination){
//            List<Integer> select = new ArrayList<>();
//
//            for(Integer i : list){
//                select.add(col.get(i));
//            }
//
//            result.add(select);
//        }
//
//        return result;
//    }
//
//    //size 0 이면 안 됨! 1일 때 [[0], [1]] 리턴
//    public List<List<Integer>> combination(int size){
//
//        if(size == 0)
//            throw new IllegalArgumentException();
//
//        if(map.containsKey(size)) {
//            return map.get(size);
//        }
//
//        if(size == 1){
//            List<Integer> list = new ArrayList<>();
//            list.add(0);
//
//            List<List<Integer>> com = new ArrayList<>();
//            com.add(list);
//
//            list = new ArrayList<>();
//            list.add(1);
//            com.add(list);
//
//            map.put(size, com);
//
//            return com;
//        }
//
//        List<List<Integer>> preList =
//                map.containsKey(size - 1) ? map.get(size - 1) : combination(size - 1);
//
//        List<List<Integer>> list = new ArrayList<>();
//
//        for(List<Integer> l : preList){
//            List<Integer> e = new ArrayList<>();
//            e.add(0);
//            for(Integer i : l){
//                e.add(i + 1);
//            }
//            list.add(e);
//        }
//
//        List<Integer> e = new ArrayList<>();
//
//        for(int i = 1; i <= size; i++)
//            e.add(i);
//
//        list.add(e);
//
//        map.put(size, list);
//
//        return list;
//    }
//
//    public boolean checkUnique(String[][] relation, List<Integer> col){
//        Set<String> set = new HashSet<>();
//
//        for(int i = 0; i < relation.length; i++){
//            StringBuilder sb = new StringBuilder();
//
//            for(int j = 0; j < col.size(); j++)
//                sb.append(relation[i][col.get(j)]);
//
//            set.add(sb.toString());
//        }
//
//        return set.size() == relation.length;
//    }
//}