package firth;
/* Sort.java
 * This program stores methods for selection, insertion sorting
 * @author Dalton Firth
 * @version 2016/11/15
 */
public class sort {

	public sort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * this method sorts an integer array from smallest to largest using
	 * selection sort
	 * 
	 * @param a
	 *            an int array that will be sorted
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
				if (a[i].compareTo(a[j]) > 0) {
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
				a[j+1] = temp;
			}

		}

	}
	
	/**
	 * this method sorts a double array from smallest to largest using
	 * insertion sort
	 * 
	 * @param a
	 *            a double array that will be sorted
	 */
	public static void insertion(double[] a) {

		double temp = 0;// a temporary variable that is used to hold an array value
						// for switching places
		int j;

		for (int i = 1; i < a.length; i++) {

			temp = a[i];

			//if the value at a[i] is smaller than a[i-1] then it switches values until the correct position is found
			if (a[i] < a[i - 1]) {
				for (j = i - 1; (j >= 0) && a[j] > temp; j--) {

					a[j + 1] = a[j];

				}
				a[j+1] = temp;
			}

		}

	}
	
	/**
	 * this method sorts a String array from smallest to largest using
	 * insertion sort
	 * 
	 * @param a
	 *            a String array that will be sorted
	 */
	public static void insertion(String[] a) {

		String temp = null;// a temporary variable that is used to hold an array value
						// for switching places
		int j;

		for (int i = 1; i < a.length; i++) {

			temp = a[i];

			//if the value at a[i] is smaller than a[i-1] then it switches values until the correct position is found
			if (a[i].compareTo(a[i - 1])<0) {
				for (j = i - 1; (j >= 0) && a[j].compareTo(temp) > 0 ; j--) {

					a[j + 1] = a[j];

				}
				a[j+1] = temp;
			}

		}

	}
	
	
	
	public static void bubble(int[] a) {
		
		
		
		
		
		
	}
	

}
