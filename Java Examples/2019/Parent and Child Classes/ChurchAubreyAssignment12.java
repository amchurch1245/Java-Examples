/*
 * Name: Aubrey Church
 * Class: CS1150
 * Due: Dec 5, 2019
 * Description: Assignment #12
 * Purpose: To learn to use inheritance and polymorphism and 
 * read from a file
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ChurchAubreyAssignment12 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		// Setup the file reference variable to refer to the text file
		File inputFileName = new File("assignment12.txt");
			
		// Open the file for reading by creating a scanner for the file
		Scanner inputFile = new Scanner (inputFileName);

	} //end main

} //end main class

//Animal Class
class Animal {
	//Private data fields
	private String name;
	private double weight;
	private String food;
	private String location;
	
	public Animal () {
		
	}
	
	//Constructor 
	public Animal (String name, double weight, String food, String location) {
		this.name = name;
		this.weight = weight;
		this.food = food;
		this.location = location;
	} //end constructor
	
	//Getters
	public String getName() {
		return name;
	}
	public double getWeight() {
		return weight;
	}
	public String getFood() {
		return food;
	}
	public String getLocation() {
		return location;
	}
	//end Getters
	
	//Actions
	public void eat() {
		System.out.println("Animal is eating");
	}
	public void sleep() {
		System.out.println("Animal is sleeping - do not disturb");
	}
	public void swim() {
		System.out.println("Animal is swimming");
	}
	//end actions
} //end Animal class

//Panther class
class Panther extends Animal {
	//Constructor
	public Panther (String name, double weight, String food, String location) {
		super.getName();
		super.getWeight();
		super.getFood();
		super.getLocation();
	} //end constructor
	
	//Actions
	public void eat() {
		System.out.println("Panther is eating");
	}
	public void sleep() {
		System.out.println("Panther is sleeping");
	}
	public void swim() {
		super.swim();
	}
	//end actions
} //end Panther class

//Penguin class
class Penguin extends Animal {
	//Constructor
	public Penguin (String name, double weight, String food, String location) {
		setName(name);
		setWeight(weight);
		setFood(food);
		setLocation(location);
	} //end constructor
	
	//Actions
	public void eat() {
		System.out.println("Penguin is eating");
	}
	public void sleep() {
		super.sleep();
	}
	public void swim() {
		System.out.println("Penguin is swimming");
	}
	//end actions
} //end Penguin class

//Bear class
class Bear extends Animal {
	//Constructor
	public Bear (String name, double weight, String food, String location) {
		setName(name);
		setWeight(weight);
		setFood(food);
		setLocation(location);
	} //end constructor
	
	//Actions
	public void eat() {
		System.out.println("Bear is eating");
	}
	public void sleep() {
		System.out.println("Bear is sleeping");
	}
	public void swim() {
		System.out.println("Bear is swimming");
	}
	//end actions
} //end Bear class

//Wolf class
class Wolf extends Animal {
	//Constructor
	public Wolf (String name, double weight, String food, String location) {
		setName(name);
		setWeight(weight);
		setFood(food);
		setLocation(location);
	} //end constructor
	
	//Actions
	public void eat() {
		super.eat();
	}
	public void sleep() {
		super.sleep();
	}
	public void swim() {
		super.swim();
	}
	//end actions
} //end Wolf class



