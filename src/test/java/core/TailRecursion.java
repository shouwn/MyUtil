package core;

// 자바 8 이상부터는 tail recursion 을 없앰
// 어디서 호출되었는지를 확인하기 위한 보안상의 이유로
public class TailRecursion {

    public int fibonacci(int n, int a, int b){
        if(n == 0)
            return a;
        if(n == 1)
            return b;

        return fibonacci(n - 1, b, a + b);
    }

    public int fibonacci(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        return fibonacci(n -1 ) + fibonacci(n - 2);
    }

    public static void main(String[] args){
        System.out.println(new TailRecursion().fibonacci(10, 0, 1));
        System.out.println(new TailRecursion().fibonacci(10));
    }
}
