/*
 * Aubrey Church
 * CS 2300
 * Due 10/22/2020
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.*;
import java.util.Arrays;

public class Church_A3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Part A
		
		//Default for if it is not a 3X3 matrix
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		
		//Accepting inputs
		Scanner input = new Scanner(System.in);
		System.out.println("Enter File Name: ");
		String filename = input.nextLine();
		System.out.println("Enter Output File Name: ");
		String outputfile = input.nextLine();
		
		PrintWriter writer = new PrintWriter(outputfile);
		
		
		File name = new File(filename);
		Scanner moves = new Scanner (name);
		
		//2x2 matrix inputs
		double mata = moves.nextInt();
		double matb = moves.nextInt();
		double ba = moves.nextInt();
		double matc = moves.nextInt();
		double matd = moves.nextInt();
		double bb = moves.nextInt();
		
		//3x3 matrix inputs
		if (moves.hasNext()) {
			c1 = moves.nextInt();
			c2 = moves.nextInt();
			c3 = moves.nextInt();
		} //end for 3X3
		
		//Creating Matrix A (hardcoding for better understanding)
		double [][] matA = new double [2][2];
		matA[0][0] = mata;
		matA[0][1] = matb;
		matA[1][0] = matc;
		matA[1][1] = matd;
		
		//Creating vector B
		double [][] vecB = new double [2][1];
		vecB[0][0] = ba;
		vecB[1][0] = bb;
		
		//Determinant
			//Determinate = (ad)-(bc)
		double determ = (mata*matd) - (matb*matc);;
		
		if (determ == 0) {
			System.out.println("System Inconsistent");
			writer.println("System Inconsistent");
		} //end if
		
		else {
			//Inverse
				//Inverse A = 1/detA
			double inverseA = 1/(determ);
			//A inverse
			double matAIa= (mata * inverseA);
			double matAIb = (matb * inverseA);
			double matAIc = (matc * inverseA);
			double matAId = (matd * inverseA);
		
			//Solving for x (x = A(-1)*b)
			double x = (matAIa * ba) + (matAIb * bb);
			double y = (matAIc * ba) + (matAId * bb);
			
			//print
			System.out.println("Solution for X: ");
			writer.println("Solution for X: ");
			System.out.printf("%.4f\n",x);
			writer.printf("%.4f\n",x);
			System.out.printf("%.4f\n", y);
			writer.printf("%.4f\n",y);
			System.out.println("");
			writer.println(" ");
		} //end else
		
//End for part A		
//Part B
		//eigenvalues (^)
		double mba = mata;
		double mbb = matb;
		double mbc = matc;
		double mbd = matd;
		
	
		//ay^2 - by + c = 0
		double a = 1;
		double b = -(mba+mbd);
		double c = (mba*mbd)-(mbb*mbc);
		
		//Quadratic
		double s1 = ((b*b) - 4*(a*c));
		if (s1 < 0) {
			s1 = s1*(-1);
		} //end if for negative
		double s2 = Math.sqrt(s1);
		double divide = 2*a;
		
		if (divide == 0) {
			System.out.println("no real eigenvalues");
		} //end if 
		else {
			//eigenvalues 
			double y1 = (-b + s2)/divide;
			double y2 = (-b - s2)/divide;
			
			//eigenvectors
			double mat1a = mata - y1;
			double reca1 = 1/mat1a;		//recrip of 1,1
			double r1b = matb * reca1;
			
			
			double mat2a = mata - y2;
			double reca2 = 1/mat2a;
			double r2b = matb * reca2;
			
			if (y1 == y2) {
				System.out.println("There is only one eigenvalue:");
				writer.println("There is only one eigenvalue:");
				System.out.printf("%.4f\t",y1); //a
				writer.printf("%.4f\t",y1);
				System.out.printf("%.4f\n", matb); //b
				writer.printf("%.4f\n", matb);
				System.out.printf("%.4f\t\t", matc); //c
				writer.printf("%.4f\t\t", matc);
				System.out.printf("%.4f\n", y1); //d
				writer.printf("%.4f\n", y1);
				System.out.println(" ");
				writer.println(" ");
				
				System.out.println("Eigenvectors: ");
				writer.println("Eigenvectors: ");
				System.out.printf("%.4f\t\t", r1b); //over 1 in vec //a
				writer.printf("%.4f\t\t", r1b);
				System.out.printf("%.4f\n", matb); //b
				writer.printf("%.4f\n", matb);
				System.out.printf("%.4f\t\t", matc); //c
				writer.printf("%.4f\t\t", matc);
				System.out.printf("%.4f\n", r2b); //over 1 in vec //d
				writer.printf("%.4f\n", r2b);
				System.out.println(" ");
				writer.println(" ");
				
				//Transpose R 
				//a b c d turns to a c b d
				//step 1: R * ^
				double Step_1a = (r1b*y1) + (matb*matc); //Ra*^a + Rb*^c
				double Step_1b = (r1b*matb) + (matb*y2); //Ra*^b + Rb*^d
				double Step_1c = (matc*y1) + (r2b*matc); //Rc*^a + Rd*^c
				double Step_1d = (matc*matb) + (r2b*y2); //Rc*^b + Rd*^d
			
				//solution = step1*R(t)
					//r(t) means rb = Rc and rc = Rb
				double soluta = (Step_1a*r1b) + (Step_1b*matb);
				double solutb = (Step_1a*matc) + (Step_1b*r2b);
				double solutc = (Step_1c*r1b) + (Step_1d*matb);
				double solutd = (Step_1d*matc) + (Step_1d*r2b);
			
				//Print
				System.out.println("R^R(t): ");	
				writer.println("R^R(t): ");
				System.out.printf("%.4f\t\t", soluta); 
				writer.printf("%.4f\t\t", soluta);
				System.out.printf("%.4f\n", solutb);
				writer.printf("%.4f\n", solutb);
				System.out.printf("%.4f\t\t", solutc); 
				writer.printf("%.4f\t\t", solutc);
				System.out.printf("%.4f\n", solutd); 
				writer.printf("%.4f\n", solutd); 
				System.out.println(" ");
				writer.println(" ");
				
				//If for if A = R^R(t)
				if (soluta == mata) {
					if (solutb == matb) {
						if (solutc == matc) {
							if (solutd == matd) {
								System.out.println("1");
								writer.println("1");
							}
						}
					}
				} //end nested if for A=R^R(t)
				else {
					System.out.println("0");
					writer.println("0");
				} //end else for not equal
			} //end if 
			
			else {
				System.out.println("Eigenvalues:"); //(^)
				writer.println("Eigenvalues:");
				System.out.printf("%.4f\t", y1); //a
				writer.printf("%.4f\t", y1);
				System.out.printf("%.4f\n", matb); //b
				writer.printf("%.4f\n", matb);
				System.out.printf("%.4f\t\t", matc); //c
				writer.printf("%.4f\t\t", matc);
				System.out.printf("%.4f\n", y2); //d
				writer.printf("%.4f\n", y2);
				System.out.println(" ");
				writer.println(" ");
				
				System.out.println("Eigenvectors: ");	//(R)
				writer.println("Eigenvectors: ");
				System.out.printf("%.4f\t\t", r1b); //over 1 in vec //a
				writer.printf("%.4f\t\t", r1b);
				System.out.printf("%.4f\n", matb); //b
				writer.printf("%.4f\n", matb);
				System.out.printf("%.4f\t\t", matc); //c
				writer.printf("%.4f\t\t", matc);
				System.out.printf("%.4f\n", r2b); //over 1 in vec //d
				writer.printf("%.4f\n", r2b);
				System.out.println(" ");
				writer.println(" ");
				
				//Transpose R 
					//a b c d turns to a c b d
				//step 1: R * ^
				double Step_1a = (r1b*y1) + (matb*matc); //Ra*^a + Rb*^c
				double Step_1b = (r1b*matb) + (matb*y2); //Ra*^b + Rb*^d
				double Step_1c = (matc*y1) + (r2b*matc); //Rc*^a + Rd*^c
				double Step_1d = (matc*matb) + (r2b*y2); //Rc*^b + Rd*^d
				
				//solution = step1*R(t)
					//r(t) means rb = Rc and rc = Rb
				double soluta = (Step_1a*r1b) + (Step_1b*matb);
				double solutb = (Step_1a*matc) + (Step_1b*r2b);
				double solutc = (Step_1c*r1b) + (Step_1d*matb);
				double solutd = (Step_1d*matc) + (Step_1d*r2b);
				
				//Print
				System.out.println("R^R(t): ");	
				writer.println("R^R(t): ");	
				System.out.printf("%.4f\t\t", soluta); 
				writer.printf("%.4f\t\t", soluta); 
				System.out.printf("%.4f\n", solutb); 
				writer.printf("%.4f\n", solutb);
				System.out.printf("%.4f\t\t", solutc); 
				writer.printf("%.4f\t\t", solutc); 
				System.out.printf("%.4f\n", solutd); 
				writer.printf("%.4f\n", solutd);
				System.out.println(" ");
				writer.println(" ");
				
				//If for if A = R^R(t)
				if (soluta == mata) {
					if (solutb == matb) {
						if (solutc == matc) {
							if (solutd == matd) {
								System.out.println("1");
								writer.println("1");
								System.out.println("");
								writer.println("");
							}
						}
					}
				} //end nested if for A=R^R(t)
				else {
					System.out.println("0");
					writer.println("0");
					System.out.println("");
					writer.println("");
				} //end else for not equal
				
			} //end nested else 
		} //end else
		
		
//Part B
		//Restating values for understanding purpose
		double ax = mata;
		double ay = matc;
		double az = c1;
		double bx = matb;
		double by = matd;
		double bz = c2;
		double cx = ba;
		double cy = bb;
		double cz = c3;
		
		int D = 0;
		//determining 2D or 3D
		if (c1 == 0) {
			if (c2 == 0) {
				if (c3 == 0) {
					D = 2;
				} //end nested if c3
			} //end nested if c2
		} //end c1
		else {
			D = 3;
		} //end else
		
		//Area
			//Area is Ax(By-Cy)+Bx(Cy-Ay)+Cx(Ay-By)/2
		//2D
		if (D==2) {
			//Area
			double area2dStep1 = ax*(by-cy);
			double area2dStep2 = bx*(cy-ay);
			double area2dStep3 = cx*(ay-by);
			double area2dStep4 = area2dStep1+area2dStep2+area2dStep3;
			double area2d = area2dStep4/2;
			if (area2d < 0) {
				area2d = area2d*(-1);
			} //end if for absolute val
			System.out.print("Area: ");
			writer.print("Area: ");
			System.out.printf("%.4f\n", area2d);
			writer.printf("%.4f\n", area2d);
			//Line 
				//line: (ay-by)x + (bx-ax)y + (ax*by - bx*ay) = 0
			//distance of third point to line
				//distance: |(ay-by)(cx) + (bx-ax)(cy) + (ax*by - bx*ay)| / sqrt(a^2 + b^2)
			double disStep1 = (ay-by)*cx;
			double disStep2 = (bx-ax)*cy;
			double disStep3 = (ax*by) - (bx*ay);
			double disStep4 = disStep1 + disStep2 + disStep3;
			if (disStep4 <0 ) {
				disStep4 = disStep4*(-1);
			} //end if for absolute val
			double disStep5 = ((ay-by)*(ay-by)) + ((bx-ax)*(bx-ax));
			double disStep6 = Math.sqrt(disStep5);
			double distance2d = disStep4/disStep6;
			System.out.print("Distance: ");
			writer.print("Distance: ");
			System.out.printf("%.4f\n", distance2d);
			writer.printf("%.4f\n", distance2d);
		} //end if for 2D calculations
		
		//3D
		if (D==3) {
			//sides
			double sidea1 = ((bx - cx)*(bx - cx));
			double sidea2 = ((by - cy)*(by - cy));
			double sidea3 = ((bz - cz)*(bz - cz));
			double sidea4 = sidea1+sidea2+sidea3;
			double sidea = Math.sqrt(sidea4);
			
			double sideb1 = ((ax - cx)*(ax - cx));
			double sideb2 = ((ay - cy)*(ay - cy));
			double sideb3 = ((az - cz)*(az - cz));
			double sideb4 = sideb1+sideb2+sideb3;
			double sideb = Math.sqrt(sideb4);
			
			double sidec1 = ((ax - bx)*(ax - bx));
			double sidec2 = ((ay - by)*(ay - by));
			double sidec3 = ((az - bz)*(az - bz));
			double sidec4 = sidec1+sidec2+sidec3;
			double sidec = Math.sqrt(sidec4);
			
			//perimeter
			double p = sidea+sideb+sidec;
			
			//semiperimeter
			double s = p/2;
			
			//area
			double area1 = s*(s-sidea)*(s-sideb)*(s-sidec);
			double area = Math.sqrt(area1);
			System.out.print("Area: ");
			writer.print("Area: ");
			System.out.printf("%.4f\n", area);
			writer.printf("%.4f\n", area);
			
			//Create a plane
				//(ax ay az, bx by bz)
			//midpoints
			double midx = (ax+bx)/2;
			double midy = (ay+by)/2;
			double midz = (az+bz)/2;
			
			//normal of x
			double normx1 = bx-ax; 
			double normx2 = (normx1*normx1);
			double normx3 = Math.sqrt(normx2);
			double normx = normx1/normx3; //ax
			
			//normal of y
			double normy1 = by-ay;
			double normy2 = (normy1*normy1);
			double normy3 = Math.sqrt(normy2);
			double normy = normy1/normy3; //by
			
			//normal of z
			double normz1 = bz-az;
			double normz2 = (normz1*normz1);
			double normz3 = Math.sqrt(normz2);
			double normz = normz1/normz3; //cz
			
			double dD = -((normx*ax) + (normy*ay) + (normz*az));
			
			//distance
			double dis1 = ((normx*cx) + (normy*cy) + (normz*cz) + dD);
			if (dis1 < 0) {
				dis1=dis1*(-1);
			} //end if for absolute val
			
			double dis2 = (normx*normx) + (normy*normy) + (normz*normz);
			double dis3 = Math.sqrt(dis2);
			double dis = dis1/dis3;
			System.out.print("Distance: ");
			writer.print("Distance: ");
			System.out.printf("%.4f\n", dis);
			writer.printf("%.4f\n", dis);
		} //end if for 3D calculations
		
		moves.close();
		writer.close();
	} //end main

} //end class
