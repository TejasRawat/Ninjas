package collection.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtilImpl implements ArrayUtil {

	@Override
	public int binarySearch(int[] a, int low, int high, int key) {

		if (low > high) {
			return -1;
		}

		int mid = (low + high) / 2;

		if (key == a[mid]) {
			return mid;
		} else if (key > a[mid]) {
			return binarySearch(a, mid + 1, high, key);
		} else {
			return binarySearch(a, low, mid - 1, key);
		}
	}

	@Override
	public int findPivot(int[] a, int low, int high) {

		if (high < low)
			return -1;

		int mid = (low + high) / 2;

		if (a[mid] > a[mid + 1])
			return mid;
		if (a[mid] < a[mid - 1])
			return (mid - 1);
		if (a[low] >= a[mid])
			return findPivot(a, low, mid - 1);
		return findPivot(a, mid + 1, high);
	}

	@Override
	public ArrayList<Pair> getAllPair(int[] a) {

		ArrayList<Pair> list = new ArrayList<Pair>();

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {

				Pair pair = new Pair(a[i], a[j]);
				list.add(pair);
			}
		}
		return list;
	}

	@Override
	public int largetSumContgArray(int[] a) {

		return 0;
	}

	@Override
	public int[] bubbleSort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {

				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			System.out.print("Array after pass " + (i + 1) + " ");
			for (int k : a) {
				System.out.print("," + k);
			}
			System.out.println();
		}
		return a;
	}

	@Override
	public int[] selectionSort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {

			int min = i;

			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;

			System.out.print("Array after pass " + (i + 1) + " ");
			for (int k : a) {
				System.out.print("," + k);
			}
			System.out.println();
		}
		return a;
	}

	@Override
	public int[] segregateZeroOnes(int[] a) {

		for (int i = 0, j = a.length - 1; i < j;) {
			if (a[i] == 1 && a[j] == 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;

				i++;
				j--;
			} else if (a[i] == 1 && a[j] == 1) {
				j--;
			} else if (a[i] == 0 && a[j] == 1) {
				i++;
				j--;
			} else {
				i++;
			}
		}
		return a;
	}

	@Override
	public List<ArrayList<Integer>> getAllContgArray(ArrayList<Integer> data) {

		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		List<ArrayList<Integer>> tempList = null;
		
		for(int i=0; i<data.size(); i++){
			
			tempList = getOneTouple(i,data);
	
			for(ArrayList<Integer> ls : tempList){
				list.add(ls);
			}
		}
		return list;
	}
	
	private List<ArrayList<Integer>> getOneTouple(int index, ArrayList<Integer> data) {

		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		for (int i = index; i <= data.size(); i++) {
			ArrayList<Integer> ls = new ArrayList<Integer>();
			ls.addAll(data.subList(index, i));
			list.add(ls);
		}
		return list;
	}
	
	@Override
	public int getLargestSum(List<ArrayList<Integer>> list){
		
		int temp = Integer.MIN_VALUE;

		for(ArrayList<Integer> toupleList : list){
			int sum = getSum(toupleList);

			if(sum >= temp){
				temp = sum;
			}
		}
		return temp;
	}

	private int getSum(ArrayList<Integer> toupleList) {

		int sum = 0;
		
		for(Integer i : toupleList){
			sum = sum +i;
		}
		return sum;
	}

}
