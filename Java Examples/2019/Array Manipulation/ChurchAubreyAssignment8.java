/* 
 *  * Name: Aubrey Church
 * Class: CS1150
 * Due: Nov 1, 2019
 * Description: Assignment #8
 * Purpose: To write a program that creates two arrays and then performs
 * several manipulations on them. The first array stores rainfall amounts
 * and the second stores city names that correspond to the first.
 */
public class ChurchAubreyAssignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Code in main will start here
//Arrays		
double [] rainfall = {15.54, 37.19, 53.19, 34.25, 46.00, 35.82, 61.90};
String [] cities = {"Denver", "Seattle", "Orlando", "Austin", "Vancouver", "Chicago","Miami"};

//Starting Variables
double totRain = 0;
double average = 0;
int largeNum = -1;

//Calling the Methods
dispRainfall(rainfall, cities);
System.out.println("");
totRain = compTotRain(rainfall);
average = compAveRain(rainfall, totRain);
System.out.println("");
largeNum = findCityMostRain(rainfall);
System.out.println("");
System.out.println("City with most rain is " + cities[largeNum] + " with " + rainfall[largeNum] + " inches per year");
System.out.println(" ");
dispCitiesAboveAverage(rainfall, cities, average);

//Dog class in main
Dog[] dogArray = new Dog[5];
Dog dog1 = new Dog("Rover", "woof woof");
Dog dog2 = new Dog("Max", "arf arf arf");
Dog dog3 = new Dog("Tiny", "yap yap yap");
Dog dog4 = new Dog("Trooper", "ruff ruff ruff");
Dog dog5 = new Dog("Magoo", "bow wow bow wow");
dogArray[0] = dog1;
dogArray[1] = dog2;
dogArray[2] = dog3;
dogArray[3] = dog4;
dogArray[4] = dog5;
makeDogsBark(dogArray);

	} //end main
//Methods will begin here
//Display Rainfall	
public static void dispRainfall (double [] rainfall, String [] cities) {
	System.out.println("-------------------------------");
	System.out.println("City 		Yearly Rainfall");
	System.out.println("-------------------------------");
	
	//For for table
	for (int i = 0; i < 7; i++) {
		System.out.println(cities[i] + "		" + rainfall[i]);
	} //end for for table
} //end display rainfall
	
//Compute total rain of all the cities
public static double compTotRain (double [] rainfall) {
	double totRain = 0;
	
	//For for adding all the rainfall
	for (int i=0; i<7; i++) {
		totRain = totRain + rainfall[i];
	} //end for
	System.out.println("Total rainfall for all cities is " + totRain);
	return totRain;
} //end compTotRain

//Compute the average rain of all the cities
public static double compAveRain (double [] rainfall, double totRain) {
	double average = totRain / 7;
	System.out.println("Average rainfall for all cities is "+  average);
	return average;
} //end compAveRain

//Find what space in the array has the greatest number for rainfall
public static int findCityMostRain (double [] rainfall) {
	int largeNum = 0;
	double largest = rainfall[0];
	
	//for for counter
	for (int i =0; i<7; i++) {
		
		//if for largest rainfall number
		if (rainfall[i] > largest) {
			largest = rainfall[i];
			largeNum = i;
		} //end if for largest rainfall number
	} //end for
	return largeNum;
} //end findCityMostRain

//Display all the cities that have rainfall above the average
public static void dispCitiesAboveAverage (double [] rainfall, String [] cities, double average) {
	
	//For for counter
	for (int i =0; i<7; i++) {
		
		//if for checking if cities are above average
		if (rainfall [i] > average) {
			System.out.println(cities[i] + " gets " + rainfall[i] + " inches, which is above average");
		} //end if
	} //end for
} //end dispCitiesAboveAverage

//Dog Class Method
public static void makeDogsBark (Dog [] dogArray) {
	System.out.println("");
	System.out.println("Create an array of dog objects");
	System.out.println("-------------------------------");
	//for for dog class
	for (int i = 0; i < 5; i++) {
		System.out.println(dogArray[i].getName() + " barks like this: " + dogArray[i].getBark());
	} //end for for dog class
} //end dog class method

} //end class

//Begin Dog class
class Dog {		

	private String name;					
	private String bark;					
							
	public Dog (String name, String bark) {
	   this.name = name;
	   this.bark = bark;
	}
									
	public String getName() {					
	   return name;
	}

	public void setName(String name) {
	   this.name = name;
	}

	public String getBark() {
	   return bark;
	}

	public void setBark(String bark) {
	   this.bark = bark;
	}
} // Dog

