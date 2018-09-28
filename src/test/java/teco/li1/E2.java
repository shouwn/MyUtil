package teco.li1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class E2 {

    static class BST {
        public Node root;

        static class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
                left = null; right = null;
            }
        }

        public void insert(int data) {
            Node newNode = new Node(data);
            if(root == null){
                root = newNode;
                return;
            }

            Node curNode = root;
            Node parentNode;
            while (true){
                parentNode = curNode;
                if(data < curNode.data) {
                    curNode = curNode.left;
                    if(curNode == null) {
                        parentNode.left = newNode;
                        return;
                    }
                } else {
                    curNode = curNode.right;
                    if(curNode == null){
                        parentNode.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    static class DataTraverser {
        List<Integer> list = new ArrayList<>();

        DataTraverser(BST.Node root){
            traverse(list, root);
        }

        public static void traverse(List<Integer> list, BST.Node node){
            if(node == null) return;
            traverse(list, node.right);
            list.add(node.data);
            traverse(list, node.left);
        }

        public boolean isDone(){
            return list.size() == 0;
        }

        public int findNextData(){
            return list.remove(0);
        }
    }

    public static void main(String[] args) throws IOException {
        BST bst = new BST();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
            while (tokens.hasMoreTokens()){
                bst.insert(Integer.parseInt(tokens.nextToken()));
            }
        }

        DataTraverser traverser = new DataTraverser(bst.root);
        StringBuilder sb = new StringBuilder();
        while(!traverser.isDone()){
            sb.append(traverser.findNextData());
            if(!traverser.isDone())
                sb.append(' ');
        }

        System.out.println(sb);
    }
}
