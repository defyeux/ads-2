class MyStack<T> {
    private MyArrayList<T> lst;
    private int size;

    public MyStack(int size) {
        lst = new MyArrayList<>();
    }

    public void push(T data) {
        lst.add(data);
    }

    public T pop() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Stack is empty");
        }

        T last = lst.getLast();
        lst.remove(lst.size() - 1);
        return last;
    }

    public T peek() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Stack is empty");
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