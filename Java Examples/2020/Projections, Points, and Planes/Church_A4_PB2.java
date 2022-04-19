/*
 * Aubrey Church
 * CS 2300
 * Due 11/12/2020
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Church_A4_PB2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Perspective projection
		
		//Accepting inputs
		File name = new File ("input_1-1.txt");
		Scanner moves = new Scanner (name);
			
		//output file
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Output File Name for Part 2: ");
		String outputfile = input.nextLine();
		
		PrintWriter writer = new PrintWriter(outputfile);
		
		//storing values of one row of text
		Value x1 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble());//P in part 1, Q in part 2
		Value y1NonNorm = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble());//Normal (N)
		Value z1 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble()); //M
		
		//normalize N
		double norm1 = y1NonNorm.getx() * y1NonNorm.getx();
		double norm2 = y1NonNorm.gety() * y1NonNorm.gety();
		double norm3 = y1NonNorm.getz() * y1NonNorm.getz();
		double norm4 = Math.sqrt(norm1 + norm2 + norm3);
		Value y1 = new Value (y1NonNorm.getx()/norm4, y1NonNorm.gety()/norm4, 
				y1NonNorm.getz()/norm4);
				
		//storing values of one row of text (doing this so that we use the right inputs 
		//from moves 1, wont actually be using these variables
		
				
		int step1 = 0;
		while (step1 !=3) {
					
			Value x2 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble());
			//xPrime = (q DOT n / x DOT n) * x
				
			//q DOT n: x1 DOT y1
			Value step1Per = new Value (x1.getx() * y1.getx(), x1.gety() * y1.gety(),
					x1.getz() * y1.getz()); //ADD THEM TOGETHER
				
			//x Dot n: x2 Dot y1
			Value step2Per = new Value (x2.getx() * y1.getx(), x2.gety() * y1.gety(),
					x2.getz() * y1.getz()); //ADD THEM TOGETHER
			
			//divide: step1Per / step2Per
			Value step3Per = new Value (step1Per.getx() / step2Per.getx(), 
					step1Per.gety() / step2Per.gety(), step1Per.getz() / step2Per.getz());
		
			//multiply by x: step3Per * x2
			Value perspective = new Value (step3Per.getx() * x2.getx(), step3Per.gety() * x2.gety(),
					step3Per.getz() * x2.getz());
			System.out.println();
			perspective.dispx();
			writer.printf("%.2f\t", perspective.getx());
			perspective.dispy();
			writer.printf("%.2f\t", perspective.gety());
			perspective.dispz();
			writer.printf("%.2f\t", perspective.getz());
			writer.println(" ");
			
			step1 = step1 + 1;
		} //end while
			
		moves.close();
		input.close();
		writer.close();
	} //end main
	//methods begin here
		
	} //end class

	//classes begin here