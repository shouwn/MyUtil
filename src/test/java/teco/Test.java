package teco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String input = br.readLine().trim();

            System.out.println(checkBracket(input) ? "올바른 괄호 수식입니다." : "잘못된 괄호 수식입니다.");

        }
    }

    private static boolean checkBracket(String s){
        MyCharacterStack stack = new MyCharacterStack();
        Stream.iterate(1, n -> n * 10).limit(9)
                .flatMap(n -> Stream.iterate(1, r -> r + 1)
                        .map(r -> n + " * " + r + " = " + n * r))
                .forEach(System.out::println);


        try {
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(': case '<':
                        stack.push(c);
                        break;
                    case ')':
                        if(stack.pop() != '(')
                            return false;
                        break;
                    case '>':
                        if(stack.pop() != '<')
                            return false;
                        break;
                }
            }

            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}

class MyCharacterStack {

    private Node head;

    private static class Node{
        char character;
        Node next;

        private Node(char character) {
            this.character = character;
        }

        private Node(char character, Node next) {
            this.character = character;
            this.next = next;
        }
    }

    public char push(char character){
        if(head == null)
            head = new Node(character);
        else
            head = new Node(character, head);

        return character;
    }

    public char pop(){
        if(head == null)
            throw new IllegalStateException("stack이 비어있습니다.");

        Node result = head;
        head = head.next;

        return result.character;
    }
}