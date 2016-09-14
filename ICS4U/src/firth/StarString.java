package firth;

/* StarString.java
* This program uses recursion to print a pyramid of *s
* @author Dalton Firth
* @version 2016/09/14
*/
import java.util.Scanner;

public class StarString {

	/**
	 * This is the main method for the program
	 * 
	 * @param args
	 *            a string array
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.println("please enter the number of lines you would like te pyramid to be");

		// getting the input from the user
		int numin = Math.abs(scan.nextInt());

		starString(numin);

		scan.close();
	}

	/**
	 * starString takes the input from the user and prints a pyramid of
	 * asterisks at an exponential growth
	 * 
	 * @param input
	 *            an integer that is used to determine the number of lines in
	 *            the pyramid
	 */
	public static void starString(int input) {


		if (Math.pow(2, input) != 1)
			starString(input - 1);

		// printing the lines of *
		for (int i = 0; i < Math.pow(2, input); i++)
			System.out.print("*");
		System.out.println();// Separating the lines of *s

	}

}
