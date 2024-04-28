public class TestArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> lst = new MyArrayList<>();
        lst.add(20);
        lst.add(10);
        lst.add(30);
        lst.add(60);
        lst.add(40);
        lst.add(50);
        lst.printLst();
        lst.sort();
        lst.printLst();
        System.out.printf("Index of element that contain 20: %d\n", lst.indexOf(20));
        System.out.printf("Element with index 0: %d\n", lst.getFirst());
        lst.addFirst(0);
        System.out.println(lst.getFirst());
        lst.printLst();
        lst.set(1, 9);
        lst.printLst();
        System.out.println("Last element: " + lst.getLast());
        lst.removeFirst();
        lst.remove(1);
        lst.removeLast();
        lst.printLst();
        lst.set(0, 50);
        System.out.println("Last index of element that contain 50: " + lst.lastIndexOf(50));
        System.out.println("The size of array list: " + lst.size());
        System.out.println(lst.exists(40));
        System.out.println(lst.exists(20));
    }
}
