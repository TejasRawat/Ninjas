package dp.fibonacci;

public class FibonacciIterativeUtil {
    public static void main(String args[]) {
        int fibNum = getFibSeriesNum(8);
        System.out.println(fibNum);
    }

    private static int getFibSeriesNum(int index) {
        int fibonacciTable[] = new int[index];
        fibonacciTable[0] = 0;
        fibonacciTable[1] = 1;
        for (int count = 2; count < index; count++) {
            fibonacciTable[count] = fibonacciTable[count - 1] + fibonacciTable[count - 2];
        }
        return fibonacciTable[index-1];
    }
}
