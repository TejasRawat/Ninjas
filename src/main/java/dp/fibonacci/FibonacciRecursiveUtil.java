package dp.fibonacci;

public class FibonacciRecursiveUtil {
    public static void main(String args[]) {
        int a[] = intializeLookUpTable();

        int fib = fib(7, a);
        System.out.println(fib);
    }

    private static int fib(int index, int[] table) {
        if (table[index] == -1) {
            if (index <= 1) {
                table[index] = index;
            } else {
                table[index] = fib(index - 1, table) + fib(index - 2, table);
            }
        }
        return table[index];
    }

    private static int[] intializeLookUpTable() {
        int a[] = new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = -1;
        }
        return a;
    }
}