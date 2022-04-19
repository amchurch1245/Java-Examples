/*
 * Aubrey Church
 * CS 2300
 * Due 11/12/2020
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Church_A4_PC2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Accepting inputs
		File name1 = new File ("input_1-1.txt");
		Scanner moves1 = new Scanner (name1);
				
		//output file
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter Output File Name for Part 2: ");
		String outputfile1 = input1.nextLine();
			
		PrintWriter writer1 = new PrintWriter(outputfile1);
		
		//storing values of one row of text
		Value x11 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble()); //x components
		Value y11 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble()); //Normal (N)
		Value z11 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble()); //points (Q)
		
		while (moves1.hasNext()) {
			//line and plane intersection point
			//p = x2, q = y2, r = z2
			Value x2 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble()); //p
			Value y2 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble()); //q
			Value z2 = new Value(moves1.nextDouble(), moves1.nextDouble(), moves1.nextDouble()); //r
		
			//v=q-p (y2-x2)
			Value v = new Value (y2.getx() - x2.getx(), y2.gety() - x2.gety(),
					y2.getz() - x2.getz());
			//w=r-p (z2-x2)
			Value w = new Value (z2.getx() - x2.getx(), z2.gety() - x2.gety(),
					z2.getz() - x2.getz());
			//v cross w
			double crossx = ( (v.gety() * w.getz()) - (v.getz() * w.gety()) ); //A
			double crossy = ( (v.getx() * w.getz()) - (v.getz() * w.getx()) ); //B
			double crossz = ( (v.getx() * w.gety()) - (v.gety() * w.getx()) ); //C
			Value cross = new Value (crossx, crossy, crossz); //A B C
		
			//find d
			double d1 = (cross.getx() * x2.getx()) + (cross.gety() * x2.gety()) 
					+ (cross.getz() * x2.getz());
			double d = (-1)*d1;
		
			//Plane equation = Ax+By+Cz+d = 0
		
			//line equation x+(y-x)t: x=x1, y=y1
			//coefficients of t
			double xt = y11.getx() - x11.getx();
			double yt = y11.gety() - x11.gety();
			double zt = y11.getz() - x11.getz();
		
			//plane equation: A(x1.x+xt) + B(x1.y+yt) + C(x1.z+zt) + d = 0
			//expand: Ax1.x + Axt + Bx1.y + Byt + Cx1.z + Czt + d = 0
				//solve for t
				//Axt + Byt + Czt = -d -Ax1.x - Bx1.y -Cx1.z
				//t(Ax + By + Cz) = -d -Ax1.x - Bx1.y -Cx1.z
				//t = -d -Ax1.x - Bx1.y -Cx1.z / (Ax + By + Cz)
			double tS1 = -d - (cross.getx() * x11.getx());
			double tS2 = tS1 - (cross.gety() * x11.gety());
			double tnumerator = tS2 - (cross.getz() * x11.getz());
			double tdenom = (cross.getx() * xt) + (cross.gety() * yt) + (cross.getz() *zt);
			double t = tnumerator / tdenom;
		
			//plug in t to get new intersection points (x1.x + xt*t)
			double pointx = x11.getx() + (xt*t);
			double pointy = x11.gety() + (yt*t);
			double pointz = x11.getz() + (zt*t);
		
			//with the new points, plug into the plane equation
				//Ax+By+Cz+d = 0 (ABC = cross x y z)
			double Ax = cross.getx() * pointx;
			double By = cross.gety() * pointy;
			double Cz = cross.getz() * pointz;
			double total = Ax + By + Cz + d;
		
			//if zero, then points are in plane
			if (total == 0) {
				System.out.printf("%.4f\t",pointx, pointy, pointz);
				writer1.printf("%.4f\t",pointx, pointy, pointz);
				System.out.println(" ");
				writer1.println(" ");
			} //end if for intersection
			else {
				System.out.println("Does not intersect");
				writer1.println("Does not intersect");
			} //end else for does not intersect
					
		} //end while for moves1 hasnext
		moves1.close();
		input1.close();
		writer1.close();
				
	} //end main

} //end class
