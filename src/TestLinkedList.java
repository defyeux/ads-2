import java.util.Arrays;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> lst = new MyLinkedList<>();
        lst.add(10);
        lst.add(20);
        lst.add(40);
        lst.add(20);
        lst.add(10);
        lst.printLst();
        System.out.println(lst.get(1));
        System.out.println(lst.getLast());
        lst.remove(3);
        lst.printLst();
        lst.add(2, 30);
        lst.printLst();
        System.out.println(lst.exists(20));
        System.out.println(lst.indexOf(10));
        System.out.println(lst.lastIndexOf(10));
        Object[] newLst = lst.toArray();
        System.out.println(Arrays.toString(newLst));
    }
}
