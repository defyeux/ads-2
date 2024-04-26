import java.util.Iterator;

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

    public void sort() {
        T temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable)lst[j]).compareTo(lst[j + 1]) > 0) {
                    temp = lst[j];
                    lst[j] = lst[j + 1];
                    lst[j + 1] = temp;
                }
            }
        }
    }

//    public int compareTo(T object) {
//        return (Comparable<T>)
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

    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (lst[i] == object) {
                return true;
            }
        }

        return false;
    }

    public void clear() {
        lst = (T[]) new Object[5];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void printLst() {
        for (int i = 0; i < size; i++) {
            System.out.print(lst[i] + " ");
        }
        System.out.println();
    }

    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && lst[currentIndex] != null;
            }

            @Override
            public T next() {
                return lst[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };

        return iterator;
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