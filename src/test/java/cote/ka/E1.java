//package cote.ka;
//
//import main.reader.MyReader;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//import static java.awt.Event.ENTER;
//
//public class E1 {
//}
//
//class Solution {
//
//    Map<String, String> map = new HashMap<>();
//
//    public String[] solution(String[] record) {
//        List<Record> records = new ArrayList<>();
//
//        for(int i = 0; i < record.length; i++){
//            String[] s = record[i].split(" ");
//            switch (s[0]){
//                case "Enter":
//                    records.add(new Record(s[0], s[1]));
//                    map.put(s[1], s[2]);
//                    break;
//                case "Leave":
//                    records.add(new Record(s[0], s[1]));
//                    break;
//                case "Change":
//                    map.put(s[1], s[2]);
//                    break;
//            }
//        }
//
//        return records.stream()
//                .map(Record::toString)
//                .toArray(String[]::new);
//    }
//
//
//    class Record{
//        String type;
//        String id;
//
//        public Record(String type, String id) {
//            this.type = type;
//            this.id = id;
//        }
//
//        @Override
//        public String toString(){
//            return map.get(id) + "님이 " + (type.equals("Enter") ? "들어왔습니다." : "나갔습니다.");
//        }
//    }
//}