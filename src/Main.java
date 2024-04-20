public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> lst = new MyArrayList<>();
        lst.add(10);
        lst.add(20);
        lst.add(30);
        lst.add(40);
        lst.printLst();
        lst.add(2, 50);
        lst.printLst();
    }
}