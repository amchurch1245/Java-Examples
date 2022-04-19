/* 
 * Name: Aubrey Church
 * Class: CS1150
 * Due: Nov 7, 2019
 * Description: Assignment #9
 * Purpose: To write a program to manipulate arrays by creating
 * arrays, filling arrays with different types of values,
 * merging arrays, sorting arrays, and displaying arrays. 
 */

import java.util.Arrays;

public class ChurchAubreyAssignment9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Code in main will be placed under this line
//for PART1
int[] evenList = new int [10];
int[] oddList = new int [10];
int [] result = new int [20];
fillWithEven(evenList);
fillWithOdd(oddList);
System.out.println("Even Array Sorted");
System.out.println("----------------------------------------------");
dispList(evenList);
System.out.println("");
System.out.println("Odd Array Sorted");
System.out.println("----------------------------------------------");
dispList(oddList);
mergeArrays(evenList, oddList, result);
System.out.println("");
System.out.println("Merged Even and Odd Sorted in Descending Order");
System.out.println("----------------------------------------------");
descendingOrder(result);
dispList(result);

//for PART2	
int[] arrayA = {10, 12, 15, 42, 68, 102};
int[] arrayB = {14, 16, 18, 101, 107, 108};
int mergedNum = arrayA.length + arrayB.length;
int[] merged = new int [mergedNum];
mergeArrays(arrayA, arrayB, merged);
manMerge(arrayA, arrayB, merged);
System.out.println("");
System.out.println("Manually Merged Array Sorted in Descending Order");
System.out.println("------------------------------------------------");
dispList(merged);

	} //end class
//Methods will be placed here
	
//Filling an array with randomized even numbers and sort
public static void fillWithEven (int[] list) {
	//for for randomizing each number
	for (int i=0; i<list.length;i++) {
		int randEven = (1 + (int)(Math.random() * 37));
		list[i] = randEven*2;
	}//end for
	Arrays.sort(list);
}//end fillWithEven
	
//Filling an array with randomized odd numbers and sort
public static void fillWithOdd (int[] list) {
	//for for randomizing each number
	for (int i=0; i<list.length; i++) {
		int randOdd = (1 + (int)(Math.random() * 37));
		list[i] = ((randOdd*2) +1);
	}//end for
	Arrays.sort(list);
}//end fillWithOdd

//Display values in an array
public static void dispList (int[] list) {
	//for to display each value
	for (int i=0; i<list.length; i++) {
		System.out.println("array ["+i+"] =	"+list[i]);
	}//end for
}//end dispList

//Merge two arrays into one unsorted array
public static void mergeArrays (int[] list1, int[] list2, int[] merged) {
	//variables
	int length = list1.length + list2.length;
	int starter = 0;
	//For for list1
	for (int i=0; i<list1.length; i++) {
		merged [starter] = list1[i];
		starter++;
	}//end for for list1	
	//for for list2
	for (int j = 0; j<list2.length;j++) {
		merged [starter] = list2[j];
		starter++;
	}//end for for list2
}//end mergeArrays

//Sort array into descending order
public static void descendingOrder (int[] list) {
	//for for multiplying each element by -1
	for (int i =0; i<list.length;i++) {
		list[i] = list[i]*(-1);
	}//end for for multiplying by -1
Arrays.sort(list);
	//for for changing the values back
	for (int j =0; j<list.length;j++) {
		list[j] = list[j]*(-1);
	}//end for to change the values back
}//end descendingOrder

//Sort the merged array without the array.sort
public static void manMerge(int[] list1, int[] list2, int[] merged) {
//variables	
int minval = merged[0];
int temp=0;
	//for for placement
	for(int i = 0; i< merged.length; i++) { 
		//for for other placements
		for(int j = 0; j< merged.length-1; j++) {
			//if for determining the highest number
			if(merged[j+1]>merged[j]) {
            temp=merged[j+1];
            merged[j+1]=merged[j];
            merged[j]=temp;  
			} //end if for finding highest number
		} //end for for other placements
	} //end for for placement	
}//end manMerge
} //end main
