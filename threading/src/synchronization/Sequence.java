package synchronization;

public class Sequence {
    private int value = 0;

    public synchronized int getNext() {
        // atomic, all or nothing
        // block other threads from accessing
        value++;
        return value;
    }
}
