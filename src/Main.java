public class Main {
    public static void main(String[] args) {
        MyArrayList<String> lst = new MyArrayList<>();
        lst.add("b");
        lst.add("p");
        lst.add("a");
        lst.add("c");
        lst.add("d");
        lst.printLst();
        lst.sort();
        lst.printLst();
    }
}