class MyStack<T> implements Iterable<T> {
    private MyArrayList<T> lst;

    public MyStack() {
        lst = new MyArrayList<>();
    }

    public void push(T data) {
        lst.add(data);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        T last = lst.getLast();
        lst.removeLast();
        return last;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return lst.getLast();
    }

    public int size() {
        return lst.size();
    }

    public boolean isEmpty() {
        return lst.size() == 0;
    }
}