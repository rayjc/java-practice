package threadpool;

public class MessageProcessor implements Runnable {

    private int message;

    public MessageProcessor(int message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " [Received] Message = " + message);
        handleMessage();
        System.out.println(Thread.currentThread().getName() + " [Processed] Message = " + message);
    }

    private void handleMessage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Unable to process message " + message);
        }
    }
}
