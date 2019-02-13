package collectionframework.array;

/**
 * Example: low->high->low->high->low->high
    Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
    Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 */
public class ZigZagFashionPrint {
    public static void main(String args[]) {
        int a[] = {4, 3, 7, 8, 6, 2, 1};
        int zigZag[] = getArrayInZigZagOrder(a);
        System.out.print(zigZag);
    }

    private static int[] getArrayInZigZagOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {

        }

        return array;
    }
}
