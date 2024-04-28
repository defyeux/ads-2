public class MyMinHeap<T> implements Iterable<T> {
    private MyArrayList<T> lst;

    public MyMinHeap() {
        lst = new MyArrayList<>();
    }

    public boolean isEmpty() {
        return lst.size() == 0;
    }

    public int size() {
        return lst.size();
    }

    public T getMin() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return lst.getFirst();
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        T min = lst.getFirst();
        lst.set(0, lst.getLast());
        lst.removeLast();

        if (lst.size() != 0) {
            heapify(0);
        }

        return min;
    }

    public void insert(T data) {
        lst.add(data);
        traverseUp(lst.size() - 1);
    }

    public void printLst() {
        lst.printLst();
    }

    private void heapify(int index) {
        checkIndex(index);
        int rightIndex = rightChildOf(index);
        int leftIndex = leftChildOf(index);
        int minIndex = index;

        if (rightIndex < lst.size() && ((Comparable)lst.get(rightIndex)).compareTo(lst.get(minIndex)) < 0) {
            minIndex = rightIndex;
        }

        if (leftIndex < lst.size() && ((Comparable)lst.get(leftIndex)).compareTo(lst.get(minIndex)) < 0) {
            minIndex = leftIndex;
        }

        if (minIndex != index) {
            swap(index, minIndex);
            heapify(minIndex);
        }
    }

    private void traverseUp(int index) {
        checkIndex(index);
        int parentIndex = parentOf(index);

        while (index > 0 && ((Comparable)lst.get(index)).compareTo(lst.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parentOf(index);
        }
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = lst.get(index2);
        lst.set(index2, lst.get(index1));
        lst.set(index1, temp);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= lst.size()) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }
}
