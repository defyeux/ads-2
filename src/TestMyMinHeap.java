public class TestMyMinHeap {
    public static void main(String[] args) {
        MyMinHeap<Integer> lst = new MyMinHeap<>();
        lst.insert(1);
        lst.insert(2);
        lst.insert(6);
        lst.insert(9);
        lst.insert(7);
        lst.insert(4);
        lst.insert(10);
        lst.printLst();
        System.out.println(lst.getMin());
        System.out.println(lst.extractMin());
    }
}
