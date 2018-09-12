package collectionframework.array;

/**
 * Created by zedray on 7/31/17.
 */
public class GFG1 {

	public static void main(String[] args) {

		int[] numbers = new int[] { -1,  0};
		maxSum(numbers);
	}

	/*
	 * http://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
	 */
	private static void maxSum(int[] arr) {
	
		int max = 0;
		int maxTill = arr[0];
	
		for (int i = 1; i < arr.length; i++) {
		
			if (arr[i] > 0) {
				max += arr[i];
				maxTill = max;
			} else {
				max = 0;
				continue;
			}
		}

		System.out.print(maxTill);
	}

}
