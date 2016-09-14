package firth;

/* PermutationFinder.java
* This program uses recursion to find the number of permutations when given n and r
* @author Dalton Firth
* @version 2016/09/14
*/
import java.util.Scanner;

public class PermutationFinder {

	/**
	 * This is the main method for the program
	 * 
	 * @param args
	 *            a string array
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n, r, permutations = 0;

		Scanner scan = new Scanner(System.in);

		// getting the input from the user
		System.out.println("Enter the number of items");
		n = scan.nextInt();
		System.out.println("Enter the size of each permutation");
		r = scan.nextInt();

		permutations = permut(n, r);

		System.out.println(permutations);
		scan.close();
	}

	/**
	 * This method calculates the permutations of size r in group n
	 * 
	 * @param n
	 *            an int, the total size
	 * @param r
	 *            an int, the size of the grouping
	 * @return the possible permutations
	 */
	public static int permut(int n, int r) {
		int p = 0;
		p = factorial(n) / factorial(n - r);// equation for permutations

		return p;
	}

	/**
	 * This method performs the factorial function
	 * 
	 * @param factor
	 *            an int, this calculates the factorial value
	 * @return returns the factorilized number
	 */
	public static int factorial(int factor) {

		if (factor == 1)
			return 1;
		return factor * factorial(factor - 1);
	}

}
