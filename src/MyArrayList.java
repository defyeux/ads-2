public class MyArrayList<T> implements MyList<T> {
    private T[] lst;
    private int size;

    public MyArrayList() {
        lst = (T[]) new Object[5];
        size = 0;
    }

    public void add(T data) {
        if (size >= lst.length) {
            increaseBuffer();
        }
        lst[size++] = data;
    }

    public void add(int index, T data) {
        if (size >= lst.length) {
            increaseBuffer();
        }

        checkIndex(index);
        for (int i = size - 1; i >= index; i--) {
            lst[i + 1] = lst[i];
        }

        lst[index] = data;
        size++;
    }

    public void set(int index, T data) {
        checkIndex(index);
        lst[index] = data;
    }

    public void addFirst(T data) {
        add(0, data);
    }

    public T get(int index) {
        checkIndex(index);
        return lst[index];
    }

    public T getFirst() {
        checkIndex(0);
        return lst[0];
    }

    public T getLast() {
        checkIndex(0);
        return lst[size - 1];
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            lst[i - 1] = lst[i];
        }
        size--;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

//    public void sort() {
//        T temp;
//        for (int i = 0; i < size - 1; i++) {
//            for (int j = 0; j < size - i - 1; j++) {
//                if (lst[j] > lst[j + 1]) {
//                    temp = lst[j];
//                    lst[j] = lst[j + 1];
//                    lst[j + 1] = temp;
//                }
//            }
//        }
//    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (lst[i] == object) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (lst[i] == object) {
                return i;
            }
        }

        return -1;
    }

    public void printLst() {
        for (int i = 0; i < size; i++) {
            System.out.print(lst[i] + " ");
        }
        System.out.println();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }

    private void increaseBuffer() {
        T[] newLst = (T[]) new Object[2 * size];

        for (int i = 0; i < lst.length; i++) {
            newLst[i] = lst[i];
        }

        lst = newLst;
    }
}