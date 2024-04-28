import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private T[] lst;
    private int size;

    public MyArrayList() {
        lst = (T[]) new Object[5];
        size = 0;
    }

    /**
     * This method adds the element to the end of the list
     * Time complexity: O(1)
     * resulting in constant time complexity
     * @param data the data of the element which to be added
     */
    @Override
    public void add(T data) {
        if (size >= lst.length) {
            increaseBuffer();
        }
        lst[size++] = data;
    }

    @Override
    public void addLast(T data) {
        add(data);
    }

    /**
     * This method add the element of the list by given index
     * Time complexity: O(n), where n is the size of the array
     * resulting in linear time complexity
     * @param index the index of the element which to be added
     * @param data the data of the element which to be added
     */
    @Override
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

    /**
     * This method sets the given data to the element by the given index
     * Time complexity: O(1)
     * resulting in constant time complexity
     * @param data the data which to be set to the element
     * @param index the index of the element that to be changed
     */
    @Override
    public void set(int index, T data) {
        checkIndex(index);
        lst[index] = data;
    }

    /**
     * This method adds the element to the top of the list
     * It uses an iterative approach
     * Time complexity: O(n), where n is the size of the list
     * resulting in linear time complexity
     * @param data the data which to be set to the element
     */
    @Override
    public void addFirst(T data) {
        add(0, data);
    }

    /**
     * This method gets the element of the list by given index
     * Time complexity: O(1)
     * resulting in constant time complexity
     * @param index the index of the element of the list which to be got
     * @return the element of the array by given index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return lst[index];
    }

    /**
     * This method gets the first element of the array
     * Time complexity: O(1)
     * resulting in constant time complexity
     * @return the first element of the array
     */
    @Override
    public T getFirst() {
        checkIndex(0);
        return lst[0];
    }

    /**
     * This method gets the last element of the array
     * Time complexity: O(1)
     * resulting in constant time complexity
     * @return the last element of the array
     */
    @Override
    public T getLast() {
        checkIndex(0);
        return lst[size - 1];
    }


    /**
     * This method removes the element by given index
     * It uses an iterative approach
     * Time complexity: O(n), where n is the size of the list
     * The iterative algorithm iterates throug all number from index + 1 to size - 1
     * resulting in linear time complexity
     * @param index The index of the element which to be removed
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            lst[i - 1] = lst[i];
        }
        size--;
    }

    /**
     * This method removes the first element of the list
     * It uses an iterative approach
     * Time complexity: O(n), where n is the size of array
     * The iterative algorithm iterates through all number from 1 to size - 1
     * resulting in linear time complexity
     */
    @Override
    public void removeFirst() {
        remove(0);
    }

    /**
     * This method removes the last element
     * Time complexity: O(1), where n is the size of array
     * resulting in constant time complexity
     */
    @Override
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * This method sort the list
     * It uses an iterative approach
     * Time complexity: O(n^2), where n is the size of list
     * The iterative algorithm iterates through all number from 0 to size - 1
     * resulting in quadratic time complexity
     */
    @Override
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

    /**
     * this method returns the index of the element for the given data
     * It uses iterative approach
     * Time complexity: O(n), where n is the size of array
     * The iterative algorithm iterates through all number from 0 to size - 1
     * resulting in linear time complexity
     * @param object the data of the element whose index is to be returned
     * @return index of the first element by the given data; if there's no element with such data, return would be -1
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (lst[i] == object) {
                return i;
            }
        }

        return -1;
    }


    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (lst[i] == object) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (lst[i] == object) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] newLst = new Object[size];

        for (int i = 0; i < size; i++) {
            newLst[i] = lst[i];
        }

        return newLst;
    }

    @Override
    public void clear() {
        lst = (T[]) new Object[5];
        size = 0;
    }

    @Override
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