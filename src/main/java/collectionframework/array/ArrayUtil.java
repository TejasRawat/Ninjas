package collectionframework.array;

import java.util.ArrayList;
import java.util.List;

public interface ArrayUtil {

	public int binarySearch(int a[], int low, int high, int key);

	/*
	 * Finds the pivot(in a rotated sorted array) index, IF not rotated return
	 * -1
	 */
	public int findPivot(int a[], int low, int high);

	/*
	 * Returns all the pair elements from given Array e.g. 123 [(1,2)(1,3)(2,3)]
	 */
	public ArrayList<Pair> getAllPair(int a[]);

	/*
	 * Returns the Largest Sum Contiguous Sub Array
	 */
	public int largetSumContgArray(int a[]);

	public int[] bubbleSort(int a[]);

	public int[] selectionSort(int a[]);
	
	public int[] segregateZeroOnes(int a[]);
	
	public List<ArrayList<Integer>> getAllContgArray(ArrayList<Integer> data);
	
	public int getLargestSum(List<ArrayList<Integer>> list);

	public int[] rotateArray(int a[],int time);
	
}
