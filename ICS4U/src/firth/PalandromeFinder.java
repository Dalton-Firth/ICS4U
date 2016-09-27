package firth;

import java.util.Scanner;

public class PalandromeFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		String wordin = null;

		System.out.print("word1");

		wordin = scan.nextLine().trim();
		
		char[] wordArray = new char[wordin.length()];

		wordArray=charArray(wordin);
		

		//for (int i = 0; i < wordin.length(); i++)
			//if (wordArray[i] == ' ')
				
			//	wordArray[i] = wordArray[i+1];
		

		if (isPalandromes(wordArray))
			System.out.println("this is a palandrome");
		else
			System.out.println("this is not a palandrome");

		System.out.println(wordin);
		scan.close();
	}

	/*public static boolean isPalandrome(String wordin) {
		int wordCounter = wordin.length() - 1;
		int charTrueCounter = 0;

		for (int i = 0; i < wordin.length(); i++) {
			if (wordin.charAt(i) == wordin.charAt(wordCounter))
				charTrueCounter++;

			wordCounter--;
		}
		if (charTrueCounter == wordin.length())
			return true;
		else
			return false;
	}
	*/
	
	
	
	public static boolean isPalandromes(char[] wordArray) {
	
		//int base = wordArray.length/2;
		int countUp=0;
		int countDown=wordArray.length-1;
		
		if(wordArray.length-1==countUp)
			return true;
		
		else if (wordArray.length-1!=countUp)
		{
			if(wordArray[countUp]==wordArray[countDown])
			{
				countUp++;
				countDown--;
				isPalandromes(wordArray);
			}
		}
		
		
		return false;
	}

	public static char[] charArray(String wordin) {
		char[] wordArray = new char[wordin.length()];

		for (int i = 0; i < wordin.length(); i++)
			wordArray[i] = wordin.charAt(i);

		return wordArray;
	}

}
