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


public class Church_A5_PA {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//Part A
		//Input file: NxN matrix where matrix is stochastic
		//Solve using power method
		
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
		
		//row and col count
		while (moves.hasNextLine()) {
			++rows;
			String line = moves.nextLine();
		} //end while for line
		
		cols = rows;
		
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
		
		//Power method for NXN matrix
			//Note: max = max input of matrix
		//starter xNum
		double[][] xNum = new double [rows][1];
		//fill x0 with 1's
		for (int i=0; i < rows; i++) {
			xNum[i][0] = 1;
		} //end for to fill x0
		
		//A = mat, x0 = xNum
		
		//to start, do ten iterations
		for (int i=0; i<100; i++) {
			xNum = multMatrix(mat, xNum, rows, cols, 1);
			
			//find max of xNum
			double xNumMax = 0;
			for (int j=0; j < rows; j++) {
				if (xNum[j][0] > xNumMax) {
					xNumMax = xNum[j][0];
				} //end if for max
			} //end for for rows
			
			double[][] approxWithX = new double [rows][1];
			//divide max by xNum
			for (int k=0; k < rows; k++) {
				double abc = xNum[k][0] / xNumMax;
				approxWithX[k][0] = abc;
			} //end for with k
		} //end for ten iterations
		
		//print xNum
		System.out.println("Unsorted: ");
		writer.println("Unsorted: ");
		printMat(xNum, rows, 1, writer);
		System.out.println(" ");
		writer.println(" ");
		

		//sort
		boolean sorted = false;
		double temp = 0;
		double[][] xSort = new double[rows][1];
		for (int i=0; i<rows; i++) {
			xSort[i][0] = xNum[i][0];
		}

		while (!sorted) {
			sorted = true;
			for (int i=0; i<rows-1; i++) {
				if (xSort[i][0] < xSort[i+1][0]) {
					temp = xSort[i][0];
					xSort[i][0] = xSort[i+1][0];
					xSort[i+1][0] = temp;
					sorted = false;
				} //end if for greater than
			} //end for for rows
		} //end while for sort
		System.out.println(" ");
		
		System.out.println("Index:");
		writer.println("Index:");
		double[][] sortedmat = findNum(xNum, xSort, rows);
		printMat(sortedmat, rows, 1, writer);
		
		//close everything
		writer.close();
		input.close();
		
		
	} //end main
//Methods will begin here
	public static double dotProd (double vecA[], double vecB[], int n) {
		//n is the int value for numbers in each vector
			//works for both 2D and 3D
		double prod = 0;
		
		//for loop
		for (int i=0; i<n; i++) {
			prod = prod + (vecA[i] * vecB[i]);
		} //end for
		
		return prod;
	} //end dotProd method
	
	public static double[][] multMatrix(double[][] mat1, double[][] mat2, int rows, int col1, int col2) {
		//this is to multiply matrices with the same num of rows, but diff cols
		double[][] product = new double [rows][col2];
		for (int i=0; i < rows; i++) {
			for (int j=0; j < col2; j++) {
				for (int k=0; k < col1; k++) {
					product[i][j] += mat1[i][k] * mat2[k][j];
				} //end for for col1
			} //end for for col2
		} //end for for rows
		return product;
	} //end multMatrix method
	
	public static void printMat (double[][] mat, int row, int col, PrintWriter writer) {
		for (int i=0; i < row; i++) {
			for (int j=0; j < col; j++) {
				System.out.print(mat[i][j] + " ");
				writer.print(mat[i][j] + " ");
			} //end for for cols
			System.out.println(" ");
			writer.println(" ");
		} //end for for rows
	} //end printMat
	
	public static double[][] findNum (double[][] mat1, double[][] mat2, int rows) {
		//1 is unsorted, 2 is sorted
		double[][] sortedMat = new double[rows][1];
		for (int k=0; k < rows; k++) {
			sortedMat[k][0] = 0;
		} //end for
		
		int count = 1;
		
		for (int i=0; i < rows; i++) {
			for (int j=0; j < rows; j++) {
				double sorted = mat2[i][0];
				double unsorted = mat1[j][0];
				
				if(sorted == unsorted) {
					sortedMat[j][0] = count;
					count++;
				}
			} //end for for mat2
		} //end for for mat1
		return sortedMat;
	} //end findNum
	
} //end class
//Classes will begin here

