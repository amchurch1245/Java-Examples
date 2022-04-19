/*
 * Aubrey Church
 * CS 2300
 * Part A
 * Due 12/5/2020
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
public class Church_A5_PB {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Input file is JXN matrix
		//Accepting inputs
		File name = new File ("input_test3.txt");	//will be different
		Scanner moves = new Scanner (name);
		
		//output file
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Output File Name: ");
		String outputfile = input.nextLine();
				
		PrintWriter writer = new PrintWriter(outputfile);
				
		//input matrix
		int rows = 0;
		int cols = 0;
				
		//row count
		while (moves.hasNextLine()) {
			++rows;
			String line = moves.nextLine();
		} //end while for line	
		moves.close();
		
		//col count
		moves = new Scanner (name);
		for (int i=0; i < rows; i++) {
			if (i < rows -1) {
				String next = moves.nextLine();
			} //if to step
			if (i == (rows-1)) {
				while (moves.hasNextDouble()) {
					++cols;
					double next2 = moves.nextDouble();
				} //end while for doubles
			} //end if for last line
		} //end for for rows
		moves.close();
				
				//create matrix
		double[][] mat = new double [rows][cols];
		moves.close();
				
		//read data
		//need to find largest entry in matrix 
		double max = 0;
		moves = new Scanner (name);
		for (int i=0; i < rows; i++) {
			for (int j=0; j < cols; j++) {
				if (moves.hasNext()) {
					double tester = moves.nextDouble();
					mat[i][j] = tester;
							
					//if for max 
					if (tester > max) {
						max = tester;
					} //end if for max
				} //end if for input
			} //end for for cols
		} //end for for rows
		moves.close();		
		
		double[] wVec = new double[cols+1];
		double[] xVec = new double [cols+1];
		//double[][] fVec = new double[rows][cols+1];
		
		//fill W vector with 1's
		for (int i=0; i<cols; i++) {
			wVec[i] = 1;
		} //end for to fill w
		
		//xVec
		xVec[0] = 1;
		
		boolean trainFile = false;
		if (trainFile == false) {
			int count1 = 0;
			while (count1 != rows) {
				for (int i=1; i < cols; i++) {
					xVec[i] = mat[count1][i];
				} //end for for xVec
				double dotProduct = dotProd(xVec, wVec, cols+1);
				System.out.println("Dot product " + count1 + ": " + dotProduct);
				writer.println("Dot product " + count1 + ": " + dotProduct);
				count1++;
			} //end while for row x of matrix	
		} //end for when not using training file
		
		//closing
		writer.close();
	} //end main
//Methods begin here
	public static double dotProd (double[] vec1, double[] vec2, int n) {
		//n is the int value for numbers in each vector
			//works for both 2D and 3D
		
		//wVec[rows][1]
		double prod = 0;
		
		//for loop
		for (int i=0; i<n; i++) {
			prod = prod + (vec1[i] * vec2[i]);
		} //end for
		
		return prod;
	} //end dotProd method
} //end class
//classes begin here

