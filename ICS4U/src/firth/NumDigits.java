package firth;
/* NumDigits.java
 * This program uses recursion to determine the number of digits in a given integer
 * @author Dalton Firth
 * @version 2016/09/13
 */

import java.util.Scanner;

public class NumDigits {

	public static int counter = 0;

	
	/**
	 * This is the main method for the program
	 * @param args a string array
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		System.out.println("intput an integer");

		int numin = scan.nextInt();

		numDigits(numin);

		// outputting the number of digits in the integer
		System.out.println("the number " + numin + " has " + counter + " digit(s)");
		scan.close();
	}

	/**
	 * NumDigits counts the number of digit ins a given integer
	 * 
	 * @param input
	 *            the integer given by the user that will have the number of
	 *            digits it has determined
	 */
	public static void numDigits(int input) {

		counter++;

		if (input / 10 != 0)
			numDigits(input / 10);
	}

}
