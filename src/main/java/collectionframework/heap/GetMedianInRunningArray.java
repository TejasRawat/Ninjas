package collectionframework.heap;
import java.util.*;
import java.lang.*;
import java.io.*;

public class GetMedianInRunningArray {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
         int a[] = new int[limit];

        for(int i=0; i<limit; i++){
            a[i] = scanner.nextInt();
        }

       // int a[] = {1,2,3,4,5,6};
        List<Double> medians = getMedian(a);

        for(int i=0; i<medians.size(); i++){
            System.out.println(medians.get(i).intValue());
        }

    }

    private static List<Double> getMedian(int[] a) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        List<Double> medians = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            addNumbers(a[i], minQueue, maxQueue);
            rebalance(minQueue, maxQueue);
            medians.add(getMedian(minQueue, maxQueue));
        }
        return medians;
    }

    private static void addNumbers(int num, PriorityQueue<Integer> minQueue, PriorityQueue<Integer> maxQueue) {
        if (minQueue.size() == 0 || num < minQueue.peek()) {
            minQueue.add(num);
        } else {
            maxQueue.add(num);
        }
    }

    private static void rebalance(PriorityQueue<Integer> minQueue, PriorityQueue<Integer> maxQueue) {
        if(minQueue.size() - maxQueue.size()>=2){
            maxQueue.add(minQueue.poll());
        }else if(maxQueue.size() - minQueue.size()>=2){
            minQueue.add(maxQueue.poll());
        }
    }


    private static Double getMedian(PriorityQueue<Integer> minQueue, PriorityQueue<Integer> maxQueue) {
        PriorityQueue<Integer> biggerHeap  = minQueue.size() > maxQueue.size() ? minQueue : maxQueue;
        PriorityQueue<Integer> smallerHeap = minQueue.size() > maxQueue.size() ? maxQueue : minQueue;

        if (biggerHeap.size() == smallerHeap.size()) {
            return new Double(biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return new Double(biggerHeap.peek());
        }
    }
}
