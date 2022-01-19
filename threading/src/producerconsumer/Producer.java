package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<Integer> questions = null;
    int questionNo;

    public Producer(BlockingQueue<Integer> questions) {
        this.questions = questions;
    }

    @Override
    public void run() {
        while(true) {
            try {
                // Note: No other threads will write to this var if there's only one producer
                //  consumers will not write to questionsNo; may not need synchronization
                synchronized (this) {
                    // put instead of add for thread safety
                    questions.put(questionNo++);
                    System.out.println("Added Question: " + questionNo);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
