/*
 * Aubrey Church
 * CS 2300
 * Due 10/22/2020
 */

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
import java.lang.*;

import java.util.Arrays;

public class achurch_P3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//Part A
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		
		//Accepting inputs
		File name = new File ("input_6.txt");
		Scanner moves = new Scanner (name);
		double mata = moves.nextInt();
		double matb = moves.nextInt();
		double ba = moves.nextInt();
		double matc = moves.nextInt();
		double matd = moves.nextInt();
		double bb = moves.nextInt();
		if (moves.hasNext()) {
			c1 = moves.nextInt();
			c2 = moves.nextInt();
			c3 = moves.nextInt();
		} //end for 3X3
		
		//Creating Matrix A (hardcoding)
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
		double step1 = (mata*matd);
		double step2 = (matb*matc);
		double step3 = step1-step2;
		
		if (step3 == 0) {
			System.out.println("System Inconsistent");
		} //end if
		
		else {
			double det = 1/(step3);
			//A inverse
			double matAIa= (mata * det);
			double matAIb = (matb * det);
			double matAIc = (matc * det);
			double matAId = (matd * det);
		
			//Solving for x
			double x = (matAIa * ba) + (matAIb * bb);
			double y = (matAIc * ba) + (matAId * bb);
			
			//print
			System.out.println("Solution for X: ");
			System.out.printf("%.4f\n",x);
			System.out.printf("%.4f\n", y);
			System.out.println("");
		} //end else
		
//End for part A		
//Part B
		//eigenvalues
		double mba = mata;
		double mbb = matb;
		double mbc = matc;
		double mbd = matd;
		
		if (mba < 0) {
			mba = mba*(-1);
		} //end if for a
		if (mbb < 0) {
			mbb = mbb*(-1);
		} //end if for b
		if (mbc < 0) {
			mbc = mbc*(-1);
		} //end if for c
		if (mbd < 0) {
			mbd = mbd*(-1);
		} //end if for d
		
		double a = 1;
		double b = -(mba+mbd);
		double c = (mba*mbd)-(mbb*mbc);
		
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
			double y1 = (-b + s2)/divide;
			double y2 = (-b - s2)/divide;
			
			//eigenvectors
			double mat1a = mata - y1;
			double mat1d = matd - y1;
			double reca1 = 1/mat1a;
			double r1b = matb * reca1;
			
			
			double mat2a = mata - y2;
			double mat2d = matd - y2;
			double reca2 = 1/mat2a;
			double r2b = matb * reca2;
			
			if (y1 == y2) {
				System.out.println("There is only one eigenvalue:");
				System.out.printf("%.4f\t",y1); //a
				System.out.printf("%.4f\n", matb); //b
				System.out.printf("%.4f\t\t", matc); //c
				System.out.printf("%.4f\n", y1); //d
				System.out.println(" ");
			} //end if 
			else {
				System.out.println("Eigenvalues:");
				System.out.printf("%.4f\t", y1); //a
				System.out.printf("%.4f\n", matb); //b
				System.out.printf("%.4f\t\t", matc); //c
				System.out.printf("%.4f\n", y2); //d
				System.out.println(" ");
				
				System.out.println("Eigenvectors: ");
				System.out.printf("%.4f\t\t", r1b); //over 1 in vec //a
				System.out.printf("%.4f\n", matb); //b
				System.out.printf("%.4f\t\t", matc); //c
				System.out.printf("%.4f\n", r2b); //over 1 in vec //d
				System.out.println(" ");
			} //end nested else 
		} //end else
		
		
//Part 3
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
			System.out.printf("%.4f\n", area2d);
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
			System.out.printf("%.4f\n Distance: ", distance2d);
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
			System.out.printf("%.4f\n", area);
			
			//Create a plane
				//(ax ay az, bx by bz)
			double midx = (ax+bx)/2;
			double midy = (ay+by)/2;
			double midz = (az+bz)/2;
			
			double normx1 = bx-ax; 
			double normx2 = (normx1*normx1);
			double normx3 = Math.sqrt(normx2);
			double normx = normx1/normx3; //ax
			
			double normy1 = by-ay;
			double normy2 = (normy1*normy1);
			double normy3 = Math.sqrt(normy2);
			double normy = normy1/normy3; //by
			
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
			System.out.printf("%.4f\n", dis);
		} //end if for 3D calculations
	} //end main

} //end class
