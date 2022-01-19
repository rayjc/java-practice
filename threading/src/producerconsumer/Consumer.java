package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<Integer> questions = null;

    public Consumer(BlockingQueue<Integer> questions) {
        this.questions = questions;
    }

    @Override
    public void run() {
        while(true) {
            try {
                // take instead of remove for thread safety
                Thread.sleep(1000);
                System.out.println("Answered Question: " + questions.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
