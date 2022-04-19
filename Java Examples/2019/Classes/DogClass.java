
public class DogClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
	}

	public static void makeDogsBark (Dog [] dogArray) {
		System.out.println("Create an array of dog objects");
		System.out.println("-------------------------------");
		for (int i = 0; i < 5; i++) {
			System.out.println(dogArray[i].getName() + " barks like this: " + dogArray[i].getBark());
		}
	}
	
}


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
