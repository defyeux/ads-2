class MyStack<T> {
    private MyArrayList<T> lst;
    private int size;

    public MyStack(int size) {
        lst = new MyArrayList<>();
    }

    public void push(T data) {
        lst.add(data);
    }

    public int size() {
        return lst.size();
    }

    public boolean isEmpty() {
        return lst.size() == 0;
    }
}