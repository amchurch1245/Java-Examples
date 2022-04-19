/*
 * Aubrey Church
 * CS 2300
 * Due 11/12/2020
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Church_A4_PA {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//Accepting inputs
		File name = new File ("input_1-1.txt");
		Scanner moves = new Scanner (name);
		
		//output file
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Output File Name: ");
		String outputfile = input.nextLine();
		
		PrintWriter writer = new PrintWriter(outputfile);
		
		//storing values of one row of text
		Value x1 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble());  //eye
		Value y1 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble());  //light
		Value z1 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble()); //skip
		
		//while for other lines of text
		while (moves.hasNext()) {
		
			//v=q-p, w=r-p
			Value x2 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble()); //p
			Value y2 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble());	//q
			Value z2 = new Value(moves.nextDouble(), moves.nextDouble(), moves.nextDouble()); //r
		
		
			//Line 1: Culling
				//identify weather the triangle planar facet is front-facing vs back facing,
				//output will be binary, 1 if front and 0 if back		
		
			//c is centroid: from second line (x = x1 + x2 + x3/3, y = y1 + y2+ y3/3 ....)
			Value cent =new Value ( ((x2.getx() + y2.getx() + z2.getx()) /3), 
					((x2.gety() + y2.gety() + z2.gety()) /3), 
					((x2.getz() + y2.getz() + z2.getz()) /3) );
		
			//v = p-q (x2 y2)
			Value v = new Value ( (x2.getx() - y2.getx()), (x2.gety() - y2.gety()), 
					(x2.getz() - y2.getz()) );
			//w = q-r (x2 z2)
			Value w = new Value ( (x2.getx() - z2.getx()), (x2.gety() - z2.gety()), 
					(x2.getz() - z2.getz()) );
			//||n|| = v CROSS w / |v CROSS w|
			double vwx = ( (v.gety() * w.getz()) - (v.getz() * w.gety()) );
			double vwy = ( (v.getx() * w.getz()) - (v.getz() * w.getx()) );
			double vwz = ( (v.getx() * w.gety()) - (v.gety() * w.getx()) );
	
			double normvCrossw = Math.sqrt( (vwx*vwx) + (vwy*vwy) + (vwz*vwz) );
			Value norm = new Value ( (vwx / normvCrossw), (vwy / normvCrossw),
					(vwz / normvCrossw));
		
			//normalize the culling
				// ||cullingx| = (eyex - centroidx) / |eye - centroid|
					//|eye - cent| = sqrt
			//||cullingx||= (eyex - centroidx)/ |eye - centroid| //each component
				//|eye-cent| = sqrt(x^2 + y^2 + z^2)
					//x=eyex-centx, y=eyey-centy ...
		
			//eye-cent parts (eye-cent)
			Value step1normC = new Value ( (x1.getx() - cent.getx()), (x1.gety() - cent.gety()),
					(x1.getz() - cent.getz()) );
			//|eye - cent| (|step1normC|)
			double step2normC = Math.sqrt( (step1normC.getx() * step1normC.getx()) + 
					(step1normC.gety() * step1normC.gety()) + 
					(step1normC.getz() * step1normC.getz()) );
			//culling
			Value culling = new Value ( (x1.getx() - cent.getx()) / (step2normC), 
					(x1.gety() - cent.gety()) / (step2normC), 
					(x1.getz() - cent.getz()) / (step2normC) );
		
			//if n DOT v where v is ||culling|| < 0, it is back facing
				//norm dot culling
			double nDotv = ( (norm.getx() * culling.getx()) + (norm.gety() * culling.gety()) +
					(norm.getz() * culling.getz()) );
		
			int front = 0;
			if (nDotv < 0) {
				//back facing
				System.out.println("0");
				writer.println("0");
			} //end if
			else {
				System.out.println("1");
				writer.println("1");
				front = 1;
			} //front facing
		
			//Line 2: Lighting intensity
				//cos(theta) = nDotl / |n| |l|
				// n= n from above
				//l = light
					//|n| = length of l = sqrt(x^2 + y^2 +x^2)
			//n dot l = norm dot y1
			double ndotl = ( (norm.getx() * y1.getx()) + (norm.gety() * y1.gety()) +
					(norm.getz() * y1.getz()));
			double step1light = Math.sqrt( (norm.getx()*norm.getx()) + (norm.gety()*norm.gety())
					+ (norm.getz()*norm.getz()));
			double step2light = Math.sqrt( (y1.getx()*y1.getx()) + (y1.gety()*y1.gety())
					+ (y1.getz()*y1.getz()));
			double demonLight = step1light * step2light;
			double lightIntens = ndotl / demonLight;
		
			//if negative, output 0
			if (lightIntens < 0) {
				System.out.println("0");
				writer.println("0");
			} //end if for negative
			//if non negative, output 1
			else {
				System.out.println("1");
				writer.println("1");
			} //end else for non neg
		
		
			//Culling then intensity
				//if front facing, compute lighting intensity????
		
		} //end while for has next
		
		moves.close();
		input.close();
		writer.close();
	} //end main

} //end class

//classes

class Value {
//This will be a class to make it easier for me to write the values for a 3D system	
	//what kinda values they are
	private double x;
	private double y;
	private double z;
	
	//Set values
	public Value(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	} //end set values
	
	//get vals
	public double getx() {
		return x;
	} //end getx
	public double gety() {
		return y;
	} //end gety
	public double getz() {
		return z;
	} //end getz
	
	//displays
	public void dispx() {
		System.out.printf("%.2f\t", x);
	} //end dispx
	public void dispy() {
		System.out.printf("%.2f\t", y);
	} //end dispy
	public void dispz() {
		System.out.printf("%.2f\t", z);
	} //end dispz
	
} //end class value