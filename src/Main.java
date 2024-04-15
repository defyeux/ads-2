public class Main {
    public static void main(String[] args) {
        int lst[] = new int[] {1, 2, 3, 4, 5};
        System.out.println(first(lst, 4));
    }

    private static int first(int[] lst, int n) {
        if (n == 0) {
            return 0;
        }

        if (lst[n - 1] % 2 == 0) {
            return first(lst, n - 1);
        }

        return 1 + first(lst, n - 1);
    }
}