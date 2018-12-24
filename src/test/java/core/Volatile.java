package core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Volatile {

    private static class Test{
        static volatile int count = 0;

        static synchronized void countUp(){
            Test.count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final Runnable runnable = () -> IntStream.range(1, 1001)
//                .forEach(n -> Test.count++);
                .forEach(n -> Test.countUp()); // 원자성 보장 X

        List<Thread> threads = IntStream.range(1, 10)
                .mapToObj(n -> runnable)
                .map(Thread::new)
                .collect(Collectors.toList());

        threads.forEach(Thread::start);

        for(Thread t : threads){
            t.join();
        }

        System.out.println(Test.count);
    }
}

