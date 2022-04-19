/*
 * Aubrey Church
 * CS 2300 001
 * Due: 10/6/20
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Church_Hw2Pt2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Step 2
		File name = new File ("p2-1.txt");
		Scanner moves = new Scanner (name);
		int row = moves.nextInt();
		int col = moves.nextInt();
		
		//Step 1
		int[][] board = genBoard(row);
		dispBoard(board);
		
		//Step 2
		int mainRow = 0;
		int letter = 1;
		ArrayList<Integer> slopes = new ArrayList<Integer>();
		
		while (moves.hasNext()) {
			//Start (row/col) End (row/col)
			int sr = moves.nextInt();
			int sc = moves.nextInt();
			int er = moves.nextInt();
			int ec = moves.nextInt();
			
			//Step 3
			int slope = ((ec - sc)/ (er - sr));
			slopes.add(slope);
			
			//Because arrays start at 0
			sr--;
			sc--;
			er--;
			ec--;
			
			if(mainRow%2 ==0) {
				letter = 2;
			} //end for y
			else {
				letter = 1;
			} //end for x
		
			//Step 4
			int valid = testValid(board, sr, sc, mainRow, slopes);
			if (valid == 1) {
				board = flipCell(board, sr, sc, letter);
				board = flipCell(board, er, ec, letter);
				dispBoard(board);
			} //end if for if valid
			else {
				System.out.println("Invalid coordinate entered.");	
			} //end else
			
			mainRow++;
		} //end while
		 
		moves.close();
	} //end main
//Methods begin here

public static int [][] genBoard (int row) {
	//Method for generating board of size n
	int [][] board = new int [row][row];
	return board;
} //end genBoard method

public static void dispBoard (int [][] board) {
	//This method will display the current game board
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j<board[i].length; j++) {
			if (board[i][j] == (1)) { //1=x
				System.out.print("X ");
			} //end if for x
			if (board[i][j] == 2) {
				System.out.print("Y ");
			} //end if for y
			else {
				System.out.print(board[i][j] + " ");
			} //end else for empty cell	
		} //end for for j
		System.out.println(" ");
	} //end for for i
} //end dispBoard 


public static int testValid (int[][] board, int r, int c, int i,
		ArrayList<Integer> slopes) {
	int valid = 1;
	
	if (board[r][c] == 1) {
		valid = 0;
	}
	if (board[r][c] == 2) {
		valid = 0;
	}

	if (i != 0) {
		//Test slopes
		for (int a=0; a<i-1; a++) {
			int slope1 = slopes.get(a);
			int slope2 = slopes.get(a+1);
			int recip = -(1/slope2);
			
			if (slope1 == recip) {
				valid = 0;
			} //end if for reciprocal
		} //end for for rows
	} //end if for multiple slopes	
	
	return valid;
} //end testValid

public static int[][] flipCell (int [][] board, int row, int col, int letter) {
	//play has the coordinates, board has plays.
	//This is called after we have determined its validity
	
	board[row][col] = letter;
	
	return board;
} //end flipCell

public static void score (int [][] board) {
	int scoreX = 0;
	int scoreY = 0;
	
	for (int i = 0; i < board.length; i++) {
		for (int j = 0; j<board[i].length; j++) {
			if (board[i][j] == 1) { //1=x
				scoreX = scoreX+1;
			} //end if for scoreX
			if (board[i][j] == 2) { //2=y
				scoreY = scoreY+1;
			} //end if for scoreY
		} //end for for j
	} //end for for i
	
	System.out.println("X Score: " + scoreX);
	System.out.println("Y Score: " + scoreY);
	
} //end score

} //end class














