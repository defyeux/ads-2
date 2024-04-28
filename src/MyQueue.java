public class MyQueue<T> implements Iterable<T> {
    private MyArrayList<T> lst;

    public MyQueue() {
        lst = new MyArrayList<>();
    }

    public void enQueue(T data) {
        lst.add(data);
    }

    public T deQueue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        T first = lst.getFirst();
        lst.removeFirst();
        return first;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        return lst.getFirst();
    }

    public int size() {
        return lst.size();
    }

    public boolean isEmpty() {
        return lst.size() == 0;
    }
}
