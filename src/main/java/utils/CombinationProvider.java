package utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombinationProvider {

    private static class Node<T>{
        int depth;
        int index;
        Node<T> parent;
        T object;

        public Node(int depth, int index, Node<T> parent, T object) {
            this.depth = depth;
            this.index = index;
            this.parent = parent;
            this.object = object;
        }
    }

    public static <T> List<List<Set<T>>> select(List<T> list, int size){
        return combination(list, size);
    }

    public static <T> List<List<Set<T>>> select(List<T> list){
        return combination(list, list.size() - 1);
    }

    private static <T> List<List<Set<T>>> combination(List<T> list, int size){
        if(list.size() == 0)
            throw new IllegalArgumentException("list size is zero");

        List<List<Set<T>>> combinations = Stream.iterate(0, n -> n + 1).limit(size)
                .map(ArrayList<Set<T>>::new)
                .collect(Collectors.toList());

        LinkedList<Node<T>> queue = new LinkedList<>();

        for(int i = 0; i < list.size(); i++){
            queue.push(new Node<>(1, i, null, list.get(i)));
        }

        while(!queue.isEmpty()){
            Node<T> cur = queue.pop();

            if(cur.depth > size)
                break;

            combinations.get(cur.depth - 1).add(makeSetByNode(cur));

            for(int i = cur.index +  1; i < list.size(); i++)
                queue.push(new Node<>(cur.depth + 1, i, cur, list.get(i)));
        }

        return combinations;
    }

    private static <T> Set<T> makeSetByNode(Node<T> node){
        Set<T> set = new HashSet<>();

        for(Node<T> n = node; n != null; n = n.parent){
            set.add(n.object);
        }

        return set;
    }
}
