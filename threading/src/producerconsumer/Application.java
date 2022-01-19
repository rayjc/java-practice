package producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {

    static final int SIZE = 5;

    public static void main(String[] args) {
        // List<Integer> questions = new ArrayList<>();

        BlockingQueue<Integer> questions = new ArrayBlockingQueue<Integer>(SIZE);
        Thread t1 = new Thread(new Producer(questions));
        Thread t2 = new Thread(new Consumer(questions));

        t1.start();
        t2.start();

    }
}
