/*
 * Aubrey Church
 * CS 2300
 * Due 9/10/2020
 */
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;

public class achurch_p1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
//Part 1
	/* Write a program using a 2D array that generates and writes out
	 * five matricies defined in homework. These matricies must be
	 * generated by the program and not hard-coded */
	
	//Mat1:
		/* Rows = number of letters in first name, Columns = number of
		 * letters in last name. Starting at index position (0,0) begin
		 * filling Mat1 with values starting at 1 and increasing by 1 each
		 * time as you iterate the indices over the columns first, then over 
		 * rows second.*/
	
		//File
		File matrix1 = new File ("achurch_mat1.txt");
		matrix1.createNewFile();
		FileWriter write1 = new FileWriter (matrix1);
		
		int row1 = 6;
		int col1 = 6;
		int count1 = 0;
		int [][] mat1 = new int [row1][col1];
	
		System.out.println("Matrix 1: increment by 1");
		for (int i=0; i<col1; i++) {
			for (int j=0; j<row1; j++) {
				mat1[i][j] = count1;
				System.out.print(mat1[i][j] + " ");
				
				//File
				write1.write(mat1[i][j] + " ");
				count1++;
			} //end for for cols
			System.out.println();
		} //end for for rows
		System.out.println();
		write1.close();
		
	//Mat2: NOTE: I WILL BE ADDING ONE NUMBER TO MY LAST NAME
		/* Rows = number of letters in your last name, columns = number
		 * of letters in first name. Starting at index position (0,0) begin
		 * filling Mat2 with values starting at 3 and increasing by 3 each 
		 * time as you iterate the indices over the rows first, then over 
		 * columns second.*/
	
		//File
		File matrix2 = new File ("achurch_mat2.txt");
		matrix2.createNewFile();
		FileWriter write2 = new FileWriter ("achurch_mat2.txt");
		
		int row2 = 7;
		int col2 = 6;
		int count2 = 3;
		int [][] mat2 = new int [row2][col2];
		
		System.out.println("Matrix 2: increment by 3");
		for (int i=0; i<row2; i++) {
			for (int j=0; j<col2; j++) {
				mat2[i][j] = count2;
				System.out.print(mat2[i][j] + " ");
				
				//File
				write2.write(mat2[i][j] + " ");
				count2 = count2+3;
			} //end for for col
			System.out.println();
		} //end for for row2
		System.out.println();
		write2.close();
		
	//Mat3: NOTE: I WILL BE ADDING ONE NUMBER TO MY LAST NAME
		/* Rows = number of letters in last name, columns = number of 
		 * letters in first name. Starting at index position (0,0) begin 
		 * filling Mat3 with values starting at 0.4 and increasing by 0.3 
		 * each time as you iterate the indices over the rows first, then 
		 * over columns second.*/
		
		//File
		File matrix3 = new File ("achurch_mat3.txt");
		matrix3.createNewFile();
		FileWriter write3 = new FileWriter ("achurch_mat3.txt");
		
		int row3 = 7;
		int col3 = 6;
		double count3 = 0.4;
		double [][] mat3 = new double [row3][col3];
		
		System.out.println("Matrix 3: start at .4, increment by .3");
		for (int i=0; i<row3; i++) {
			for (int j=0; j<col3; j++) {
				mat3[i][j] = count3;
				System.out.printf("%.1f", mat3[i][j]);
				System.out.print("  ");
				
				//File
				//write3.write(mat3[i][j]);
				count3 = count3+ (.3);
			} //end for for col3
			System.out.println();
		} //end for for row3
		System.out.println();
		write3.close();
	
	//Mat4:
		/* Rows = 6, columns = 13. Starting at index position (0,0) begin 
		 * filling Mat4 with values starting at 2 and increasing by 2 each 
		 * time as you iterate the indices over the rows first, then over 
		 * columns second.*/
		
		//File
		File matrix4 = new File ("achurch_mat4.txt");
		matrix4.createNewFile();
		FileWriter write4 = new FileWriter ("achurch_mat4.txt");
		
		int row4 = 6;
		int col4 = 13;
		int count4 = 2;
		int [][] mat4 = new int [row4][col4];
		
		System.out.println("Matrix 4: start at 2, increment by 2");
		for (int i=0; i<row4; i++) {
			for (int j=0; j<col4; j++) {
				mat4[i][j] = count4;
				System.out.print(mat4[i][j] + " ");
				
				//File 
				write4.write(mat4[i][j] + " ");
				count4 = count4 + 2;
			} //end for for col4
			System.out.println();
		} //end for for row4
		System.out.println();
		write4.close();
	
	//Mat5: 
		/* Rows = 6, columns = 13. Starting at index position (0,0) begin 
		 * filling Mat5 with values starting at -7 and increasing by 1 each
		 * time as you iterate the indices over the columns first, then over
		 * rows second.*/
		
		//File
		File matrix5 = new File ("achurch_mat5.txt");
		matrix5.createNewFile();
		FileWriter write5 = new FileWriter ("achurch_mat5.txt");
		
		int row5 = 6;
		int col5 = 13;
		int count5 = -7;
		int [][] mat5 = new int [row5][col5];
		
		System.out.println("Matrix 5: start at -7, increment by 1");
		for (int i=0; i<row5; i++) {
			for (int j=0; j<col5; j++) {
				mat5[i][j] = count5;
				System.out.print(mat5[i][j] + " ");
				
				//File
				write5.write(mat5[i][j] + " ");
				count5 = count5 + 1;
			} //end for for col5
			System.out.println();
		} //end for for row5
		System.out.println();
		write5.close();
		
		
//Part2
		Scanner input1 = new Scanner (matrix1);
		Scanner input2 = new Scanner (matrix2);
		Scanner input3 = new Scanner (matrix3);
		Scanner input4 = new Scanner (matrix4);
		Scanner input5 = new Scanner (matrix5);
		
		while (input1.hasNext()) {
			while (input2.hasNext()) {
				int add1 = input1.nextInt();
				int add2 = input2.nextInt();
				int add = add1+add2;
				System.out.print(add);
			} //end while for input2
		} //end while for input1
		
	} //end main

} //end main class