package ps.array.max.contiguous.subarray.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lets take the example:
 {-2, -3, 4, -1, -2, 1, 5, -3}

 max_so_far = max_ending_here = 0

 for i=0,  a[0] =  -2
 max_ending_here = max_ending_here + (-2)
 Set max_ending_here = 0 because max_ending_here < 0

 for i=1,  a[1] =  -3
 max_ending_here = max_ending_here + (-3)
 Set max_ending_here = 0 because max_ending_here < 0

 for i=2,  a[2] =  4
 max_ending_here = max_ending_here + (4)
 max_ending_here = 4
 max_so_far is updated to 4 because max_ending_here greater
 than max_so_far which was 0 till now

 for i=3,  a[3] =  -1
 max_ending_here = max_ending_here + (-1)
 max_ending_here = 3

 for i=4,  a[4] =  -2
 max_ending_here = max_ending_here + (-2)
 max_ending_here = 1

 for i=5,  a[5] =  1
 max_ending_here = max_ending_here + (1)
 max_ending_here = 2

 for i=6,  a[6] =  5
 max_ending_here = max_ending_here + (5)
 max_ending_here = 7
 max_so_far is updated to 7 because max_ending_here is
 greater than max_so_far

 for i=7,  a[7] =  -3
 max_ending_here = max_ending_here + (-3)
 max_ending_here = 4
 */
public class KadanesAlgo {
    public static void main(String args[]) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = getMaxContgSubArraySum(arr);
        System.out.print(maxSum);
    }

    public static int getMaxContgSubArraySum(int a[]) {
        List<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subList = null;
        List<Integer> inputList = Arrays.stream(a)
                .boxed()
                .collect(Collectors.toList());
        ArrayList<Integer> ipArrayList = new ArrayList<>(inputList);
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                finalList.add(new ArrayList<>(ipArrayList.subList(i, j + 1)));
            }
        }

        int maxSum = 0;
        for (ArrayList<Integer> list : finalList) {
            int sumLocal = 0;
            for (Integer i : list) {
                sumLocal = sumLocal + i;
            }
            if (sumLocal > maxSum) {
                maxSum = sumLocal;
            }
        }

        return maxSum;
    }


    public static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {

            max_ending_here = max_ending_here + a[i];

            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }

        return max_so_far;
    }
}
