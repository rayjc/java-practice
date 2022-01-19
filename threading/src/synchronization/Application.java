package synchronization;

public class Application {

    public static void main(String[] args) {
        Sequence sequence = new Sequence();

        Worker worker1 = new Worker(sequence);
        Worker worker2 = new Worker(sequence);
        worker1.start();
        worker2.start();

    }
}

class Worker extends Thread {

    Sequence sequence = null;

    public Worker(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "- " + sequence.getNext());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}