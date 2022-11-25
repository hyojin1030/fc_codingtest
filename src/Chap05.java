import java.util.ArrayList;

// Chapter 05 - 큐 Queue
public class Chap05<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    private void enqueue(T item) {
        queue.add(item);
    }

    private void dequeue() {
        if (queue.isEmpty()) return;

        queue.remove(0);
    }

    private boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Chap05<Integer> queue = new Chap05<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
    }
}
