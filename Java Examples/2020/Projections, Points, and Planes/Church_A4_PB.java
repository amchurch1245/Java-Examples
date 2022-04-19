/*
 * Aubrey Church
 * CS 2300
 * Due 11/12/2020
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Church_A4_PB {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Accepting inputs
		File name = new File ("input_1-1.txt");
		Scanner moves = new Scanner (name);
			
		//output file
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Output File Name for Part 1: ");
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
		
		//other rows are Q in part1 and X in part 2
			//three projected image points
		int step = 0;
		while (step !=3) {
		
			Value x2 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble());
		
			//Parallel Projection
			//x = q + [(n DOT (p-q))/n DOT m] * n
	
			//p-q (x1 - x2)
			Value step1Par = new Value (x1.getx() - x2.getx(),x1.gety() - x2.gety(),
					x1.getz() - x2.getz());
		
			//n dot (p-q): y1 Dot step1Par
			Value step2Par = new Value (y1.getx() * step1Par.getx(), y1.gety() * step1Par.gety(),
					y1.getz() * step1Par.getz());
		
			//n dot m (y1 dot z1)
			Value step3Par = new Value (y1.getx() * z1.getx(), y1.gety() * z1.gety(),
					y1.getz() * z1.getz());
		
			//top divided by bottom: step2Par / step3Par
			Value step4Par = new Value (step2Par.getx()/step3Par.getx(),
					step2Par.gety()/step3Par.getx(), step2Par.getz()/step3Par.getx());
		
			//times n (step4Par * y1)
			Value step5Par = new Value (step4Par.getx() * y1.getx(), step4Par.gety()*y1.gety(),
					step4Par.getz()*y1.getz());
		
			//q + product: x2 + step5Par
			Value projection = new Value (x2.getx() + step5Par.getx(), x2.gety() + step5Par.gety(),
					x2.getz() + step5Par.getz());
			System.out.println();
			projection.dispx();
			writer.printf("%.2f\t", projection.getx());
			projection.dispy();
			writer.printf("%.2f\t", projection.gety());
			projection.dispz();
			writer.printf("%.2f\t", projection.getz());
			writer.println(" ");
			
			step = step + 1;
		} //end while part 1
		moves.close();
		input.close();
		writer.close();
			
//Perspective projection
//in seperate code now 		
/*		
 * 		//Accepting inputs
		File name1 = new File ("input_1-1.txt");
		Scanner moves1 = new Scanner (name1);
					
		//output file
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter Output File Name for Part 2: ");
		String outputfile1 = input1.nextLine();
				
		PrintWriter writer1 = new PrintWriter(outputfile1);
		
		//storing values of one row of text (doing this so that we use the right inputs 
			//from moves 1, wont actually be using these variables
		Value x11 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble());//P in part 1, Q in part 2
		Value y1NonNorm1 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble());//Normal (N)
		Value z11 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble()); //M
		
		int step1 = 0;
		while (step1 !=3) {
			
			Value x2 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble());
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
			writer1.printf("%.2f\t", perspective.getx());
			perspective.dispy();
			writer1.printf("%.2f\t", perspective.gety());
			perspective.dispz();
			writer1.printf("%.2f\t", perspective.getz());
			writer1.println(" ");
		
			step1 = step1 + 1;
		} //end while
		
		moves1.close();
		input1.close();
		writer1.close();
		*/
	} //end main
//methods begin here
	
} //end class

//classes begin here
