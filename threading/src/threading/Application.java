package threading;

public class Application {

    public static void main(String[] args) {
        Task task1 = new Task("A");
        task1.start();

        Task task2 = new Task("B");
        task2.start();

        System.out.println("Started both task1 and task2.");


        TaskRunnable taskAlt = new TaskRunnable();
        new Thread(taskAlt).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + "k => " + i);
                }
            }
        }).start();
    }
}

class Task extends Thread {

    public Task(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + "i => " + i);
        }
    }
}

class TaskRunnable implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + "j => " + i);
        }
    }
}