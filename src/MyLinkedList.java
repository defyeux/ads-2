public class MyLinkedList<T> implements MyList<T> {
    private class MyNode<T> {
        T data;
        MyNode<T> next;

        public MyNode(T data) {
            this.data = data;
            next = null;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        MyNode<T> newNode = new MyNode<>(data);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        checkIndex(index);
        MyNode<T> newNode = new MyNode<>(data);
        MyNode<T> currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        MyNode<T> subNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next = subNode;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return this.get(size - 1);
    }

    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            head = head.next;
        }
        else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
        size--;
    }

    public void removeFirst() {
        head = head.next;
    }

    public void removeLast() {
        this.remove(size - 1);
    }

    public int indexOf(Object object) {
        int index = 0;
        MyNode<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.data == object) {
                return index;
            }

            currentNode = currentNode.next;
            index++;

        }
        return -1;
    }


    public boolean exists(Object object) {
        MyNode<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.data == object) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }
    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void printLst() {
        MyNode<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
    }


}
