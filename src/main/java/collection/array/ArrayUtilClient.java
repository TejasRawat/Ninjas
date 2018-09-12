package collection.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayUtilClient {
	public static void main(String args[]) {

		ArrayUtilImpl utilImpl = new ArrayUtilImpl();

		/*
		 * int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
		 * 17, 18 }; int result = utilImpl.binarySearch(a, 0, a.length - 1, 14);
		 * System.out.println(result);
		 * 
		 * int b[] = { 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6,
		 * 7, 8, 9, 10, 11 }; int pivot = utilImpl.findPivot(b, 0, b.length -
		 * 1); System.out.println(pivot);
		 */

		/*
		 * int pairArr []= {1,2,3,4,5,6}; ArrayList<Pair> list =
		 * utilImpl.getAllPair(pairArr); for(Pair pair : list){
		 * System.out.println(pair); }
		 */

		/*
		 * int a[] = {-2, -3, 4, -1, -2, 1, 5, -3}; int largestSubArraySum =-
		 * utilImpl.largetSumContgArray(a);
		 * System.out.println(largestSubArraySum);
		 */

		/*int a[] = { 2, 7, 4, 1, 5, 3 };
		int sorted[] = utilImpl.bubbleSort(a);
		System.out.println("After  Complete Sort");
		for (int i : sorted) {
			System.out.print(","+i);
		}
		
		int b[] = { 0,0,1,0,1,1,0,0,1 };
		int arranged [] = utilImpl.segregateZeroOnes(b);
		for(int i : arranged){
			System.out.print(","+i);
		}*/
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1);
		list.add(-2);
		list.add(-11);
		list.add(-22);
		list.add(-10);
		list.add(-2);
		
		
		List<ArrayList<Integer>> dataList = utilImpl.getAllContgArray(list);
		
		Iterator<ArrayList<Integer>> itr = dataList.iterator();
		
		while(itr.hasNext()){
			if(itr.next().size() == 0){
				itr.remove();
			}
		}
		
		System.out.println("MAX SUM "+utilImpl.getLargestSum(dataList));
		
	}
}
