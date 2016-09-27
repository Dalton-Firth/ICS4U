package firth;
/* HanoiTower.java
 * This program solves a tower of Hanoi puzzle recursively
 * @author Dalton Firth
 * @version 2016/09/19
 */

import java.util.Scanner;

public class HanoiTower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("please enter the number of disks");
		
		int moves = scan.nextInt();
		String src="peg 1", aux="peg 2", des="peg 3";
		
		
		hanoi(moves, src, aux, des);

		scan.close();
	}

	/**
	 * This is the recursive method that solves the puzzle
	 * @param moves integer determines the number of disks on a pole
	 * @param src String this is the original location of the disk
	 * @param aux String this is the unused pole
	 * @param des String this is the destination of the disk
	 */
	public static void hanoi(int moves, String src, String aux, String des)
	{
		if(moves==0);
			//System.out.println("move from "+src+" to "+des); //change moves==1 to use this

		else
		{
			hanoi(moves-1, src, des, aux);
			System.out.println("move from "+src+" to "+des);
			hanoi(moves-1, aux, src, des );
		}
	
	}
	
}
