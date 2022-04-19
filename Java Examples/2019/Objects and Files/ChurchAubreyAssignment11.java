/*
 * Name: Aubrey Church
 * Class: CS1150
 * Due: Nov 21, 2019
 * Description: Assignment #11
 * Purpose: To learn more about objects and how to write a file by
 * creating race car objects, placing them into an array, and 
 * simulating a race.
 */
public class ChurchAubreyAssignment11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Code will be placed below this comment
		//Constants
		final int NUM_CARS = 5;
		
		//cars array
		RaceCar[] cars = new RaceCar[NUM_CARS];
		
		//Setting up the cars
		setupCars(cars);
		
		//Starter display
		System.out.println("Race cars at start of race");
		System.out.println("------------------------------------------------------------");
		System.out.println("Car		Driver		Average		Miles");
		System.out.println("Number				Speed		Completed");
		System.out.println("------------------------------------------------------------");
		printCars(cars);
		System.out.println("");
		System.out.println("All cars are ready - let the race begin in 5..4..3..2..1");
		
		//while for main race
		int iteration = 1;
		double minutes = 0;
		boolean raceComplete = false;
		while (!raceComplete) {
			minutes = minutes + .25;
			System.out.println("Racing time... "+ minutes + " hours");
			//if for iteration representing an hour 
			if (iteration%4 == 0) {
				//for to update each race car
				for (int i=0; i<cars.length; i++) {
					cars[i].updateOdometer();
					//if for 500 miles
					if (cars[i].getOdometer().getMiles() >= 500) {
						raceComplete = true;
					} //end if for 500 miles
				} //end for to update each race car
			} //end if for iteration representing an hour
			iteration++;
		} //end while for main race
		
		//Displaying results
		System.out.println("");
		System.out.println("Race cars at end of race");
		System.out.println("------------------------------------------------------------");
		System.out.println("Car		Driver		Average		Miles");
		System.out.println("Number				Speed		Completed");
		System.out.println("------------------------------------------------------------");
		printCars(cars);
	} //end main
	
//Methods will begin here
	//Method to fill the racecar array
	public static void setupCars(RaceCar[] cars) {
		//Hardcoding all the information
		RaceCar car1 = new RaceCar(8, "Shrek", 67);
		RaceCar car2 = new RaceCar(11, "Fiona", 85);
		RaceCar car3 = new RaceCar(7, "Donkey", 118);
		RaceCar car4 = new RaceCar(24, "Farquaad", 71);
		RaceCar car5 = new RaceCar(43, "Dragon", 108);

		//Setting the location for each car in the array
		cars[0] = car1;
		cars[1] = car2;
		cars[2] = car3;
		cars[3] = car4;
		cars[4] = car5;
		
	} //end setupCars method
	
	//Method for printing the details for each racecar
	public static void printCars (RaceCar[] cars) {
		//For loop
		for (int i=0; i<cars.length; i++) {
			RaceCar acar = cars[i];
			System.out.printf("%4d\t\t%-20s%.2f\t%.2f\n", acar.getNumber(),
					acar.getDriver(), acar.getSpeed(), acar.getOdometer().getMiles());
			
		}//end for
	}//end printCars method
} //end class

//RaceCar class to represent one race car
class RaceCar {
	//Private data fields
	private int number;
	private String driver;
	private double speed;
	private Odometer odometer;
	
	//Constructor
	public RaceCar(int number, String driver, double speed) {
		this.number = number;
		this.driver = driver;
		this.speed = speed;
		odometer = new Odometer();
	} //end constructor
		
	//Getters
	public int getNumber() {
		return number;
	} //end getNumber
	
	public String getDriver() {
		return driver;
	} //end getDriver
	
	public double getSpeed() {
		return speed;
	} //end getSpeed
	
	public Odometer getOdometer() {
		return odometer;
	} //end getOdometer
	
	//updateOdometer method
	public void updateOdometer() {
		odometer.incrementMiles(speed);
	} //end updateOdometer
} //end RaceCar class

//Odometer class to represent the odometer in a race car
class Odometer {
	//Private data fields
	private double miles;
	
	//Constructor
	public Odometer() {
		this.miles = 0;
	} //end Odometer
	
	//Getter
	public double getMiles() {
		return miles;
	} //end getMiles
	
	//IncrementMiles method
	public void incrementMiles(double speed) {
		miles = miles + speed;
	} //end IncrementMiles method
} //end Odometer class





