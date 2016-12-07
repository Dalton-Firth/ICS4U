package firth;

import java.util.Arrays;

/* Sort.java
 * This program stores methods for selection, insertion sorting
 * @author Dalton Firth
 * @version 2016/11/15
 */
public class Sort {

	/**
	 * this method sorts an integer array from smallest to largest using
	 * selection sort
	 * 
	 * @param a
	 *            an integer array that will be sorted
	 */
	public static void selection(int[] a) {

		int temp = 0;// a temporary variable that is used to hold an array value
						// for switching places

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				// replacing the values if a smaller one is found
				if (a[i] > a[j]) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}

			}

		}

	}

	/**
	 * this method sorts an double array from smallest to largest using
	 * selection sort
	 * 
	 * @param a
	 *            a double array that will be sorted
	 */
	public static void selection(double[] a) {

		double temp = 0;// a temporary variable that is used to hold an array
						// value for switching places

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				// replacing the values if a smaller one is found
				if (a[i] > a[j]) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}

			}

		}

	}

	/**
	 * this method sorts an String array from smallest to largest using
	 * selection sort
	 * 
	 * @param a
	 *            a String array that will be sorted
	 */
	public static void selection(String[] a) {

		String temp = null;// a temporary variable that is used to hold an array
							// value for switching places

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				// replacing the values if a smaller one is found
				if (a[i].compareToIgnoreCase(a[j]) > 0) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}

			}

		}

	}

	/**
	 * this method sorts an integer array from smallest to largest using
	 * insertion sort
	 * 
	 * @param a
	 *            an integer array that will be sorted
	 */
	public static void insertion(int[] a) {

		int temp = 0;// a temporary variable that is used to hold an array value
						// for switching places
		int j;

		for (int i = 1; i < a.length; i++) {

			temp = a[i];

			if (a[i] < a[i - 1]) {
				for (j = i - 1; (j >= 0) && a[j] > temp; j--) {

					a[j + 1] = a[j];

				}
				a[j + 1] = temp;
			}

		}

	}

	/**
	 * this method sorts a double array from smallest to largest using insertion
	 * sort
	 * 
	 * @param a
	 *            a double array that will be sorted
	 */
	public static void insertion(double[] a) {

		double temp = 0;// a temporary variable that is used to hold an array
						// value
						// for switching places
		int j;

		for (int i = 1; i < a.length; i++) {

			temp = a[i];

			// if the value at a[i] is smaller than a[i-1] then it switches
			// values until the correct position is found
			if (a[i] < a[i - 1]) {
				for (j = i - 1; (j >= 0) && a[j] > temp; j--) {

					a[j + 1] = a[j];

				}
				a[j + 1] = temp;
			}

		}

	}

	/**
	 * this method sorts a String array from smallest to largest using insertion
	 * sort
	 * 
	 * @param a
	 *            a String array that will be sorted
	 */
	public static void insertion(String[] a) {

		String temp = null;// a temporary variable that is used to hold an array
							// value
							// for switching places
		int j;

		for (int i = 1; i < a.length; i++) {

			temp = a[i];

			// if the value at a[i] is smaller than a[i-1] then it switches
			// values until the correct position is found
			if (a[i].compareTo(a[i - 1]) < 0) {
				for (j = i - 1; (j >= 0) && a[j].compareToIgnoreCase(temp) > 0; j--) {

					a[j + 1] = a[j];

				}
				a[j + 1] = temp;
			}

		}

	}

	/**
	 * this method sorts an integer array from smallest to largest using bubble
	 * sort
	 * 
	 * @param a
	 *            an integer array that will be sorted
	 */
	public static void bubble(int[] a) {

		int temp = 0;
		int counter = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				counter = 0;
				if (a[j + 1] < a[j]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;

					counter++;
				}

			}
			if (counter == 0)
				break;
		}

	}

	/**
	 * this method sorts a double array from smallest to largest using bubble
	 * sort
	 * 
	 * @param a
	 *            a double array that will be sorted
	 */
	public static void bubble(double[] a) {

		double temp = 0;
		int counter = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				counter = 0;
				if (a[j + 1] < a[j]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;

					counter++;
				}

			}
			if (counter == 0)
				break;
		}

	}

	/**
	 * this method sorts a String array from smallest to largest using bubble
	 * sort
	 * 
	 * @param a
	 *            a String array that will be sorted
	 */
	public static void bubble(String[] a) {

		String temp = null;
		int counter = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j].compareToIgnoreCase(a[j + 1]) > 0) {
					counter = 0;
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;

					counter++;
				}

			}
			if (counter == 0)
				break;
		}

	}

	/**
	 * 
	 * @param a an int array to be sorted
	 */
	public static void merge(int[] a) {
		int start = 0;
		int end = a.length - 1;
		combiner(a, start, end);

	}

	/**
	 * 
	 * @param a an int array that is sorted
	 * @param start the starting value
	 * @param mid the middle value
	 * @param end the ending value
	 */
	private static void mergeSort(int[] a, int start, int mid, int end) {
		int[] c = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		
		int count = start;
		int num = mid + 1;
		int i = start;
		
		while (count <= mid && num <= end) {
			if (c[count] <= c[num]) {
				a[i] = c[count];
				count++;

			} else {
				a[i] = c[num];
				num++;
			}
			i++;

		}
		while (count <= mid) {
			a[i] = c[count];
			i++;
			count++;

		}
		while (num <= end) {
			a[i] = c[num];
			i++;
			num++;

		}
	}
	
	/**
	 * combines the 2 arrays
	 * @param a an int array that will be sorted
	 * @param start the starting value of the array
	 * @param end the ending value of the array
	 */
	private static void combiner(int a[], int start, int end) {
		if (start < end) {
			int mid = (end + start) / 2;
			combiner(a, start, mid);

			combiner(a, mid + 1, end);

			mergeSort(a, start, mid, end);

		}
	}

	public static void quick(int[] a) {
		int i = 0;
		int j = a.length - 1;
		quicksortHelper(a, i, j);

	}

	private static void quicksortHelper(int a[], int i, int j) {

		int num = partition(a, i, j);

		if (i < num - 1)
			quicksortHelper(a, i, num - 1);

		if (num < j)
			quicksortHelper(a, num, j);

	}

	private static int partition(int a[], int i, int j) {

		int pivot = a[(i + j) / 2];
		int temp = 0;

		while (i <= j) {

			while (a[i] < pivot)
				i++;

			while (a[j] > pivot)
				j--;

			if (i <= j) {
				temp = a[j];
				a[j] = a[i];
				a[i] = temp;

				i++;
				j--;
			}
		}

		return i;
	}

	// public static void quick(int[] a) {
	//
	// int pivot = a[a.length-1];
	// int temp = 0;
	// int j = 0;
	// int k =-1;
	//
	//
	//
	// for(int i = 0; i<a.length;i++){
	// k =-1;
	// for (j = 0; j<a.length; j++){
	//
	// if(a[j]<pivot){
	// k++;
	// temp = a[j];
	// a[j] = a[k];
	// a[k] = temp;
	//
	// }
	//
	// }
	// temp = a[a.length-1];
	// a[a.length-1] = a[k+1];
	// a[k+1] = temp;
	// }
	//
	//
	// }

}
