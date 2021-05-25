import Animals.*;
import Base.*;

import java.util.*;

public class Main {
	static private Random random = new Random();
	static private Scanner scn;
	static private String[] randomNpcNames = new String[] {
		"Jeff", "John", "Carl", "Rick"
	};
	static private Class[] randomAnimalList = new Class[] {
		Cat.class, Dog.class, Tiger.class, Wolf.class
	};

	public static void main(String[] args) {
		Animal user;

		try{
			System.out.print("- Choose an animal (f.e. Cat): ");
			String animalClassName = readInput().trim();
			System.out.print("- What's your animal's name? ");
			var username = readInput();
			user = parseAnimalName(animalClassName, username);

			while(true) {
				String command;
				do {
					System.out.print("\n- Commands: INFO | MEET | EXIT\n> ");
					command = readInput();
				} while(command.isBlank());
				
				switch(command.toLowerCase()) {
					case "info":
						System.out.println(user.getInfo());
						break;
					case "meet":
						System.out.println(meetRandomAnimal(user));
						break;
					case "exit":
					case "quit":
					case "stop":
					case "close":
						System.out.println("Returning home...");
						return;
				}
			}
		}catch(Exception e) {
			System.out.println("[Exception]\n" + e.toString());
		}
	}

	private static String readInput() throws Exception {
		scn = new Scanner(System.in);	//Java input == pain
		try {
			return scn.nextLine();
		}catch(Exception e) {
			throw new Exception("An error occured while receiving your input.");
		}
	}

	private static Animal parseAnimalName(String animalName, String name) throws Exception {
		if(name.isBlank()) throw new Exception("The entered animal name is not allowed.");
		//Format name to PascalCase
		String input = Character.toUpperCase(animalName.charAt(0)) + animalName.substring(1).toLowerCase();
		//Create new instance of the requested animal's class
		Animal animal = ((Class<? extends Animal>)Class.forName("Animals." + input)).getDeclaredConstructor(new Class[] {String.class}).newInstance(name);
		//Make sure the object is an animal and not an animal group by checking its `call` attribute
		if(animal.getCall().isBlank()) throw new Exception("You must pick a specific animal.");
		return animal;
	}

	private static String getRandomName() {
		return randomNpcNames[random.nextInt(randomNpcNames.length)];
	}

	private static Animal getRandomAnimalInstance() throws Exception {
		return (Animal)randomAnimalList[random.nextInt(randomAnimalList.length)].getDeclaredConstructor(String.class).newInstance(getRandomName());
	}

	private static String meetRandomAnimal(Animal user) throws Exception {
		Animal animal = getRandomAnimalInstance();
		if(user.isScaredOf(animal)) {
			return "- You meet a " + animal.getClassName() + " and run away out of fear.";
		}else if(animal.isScaredOf(user)) {
			return "- You meet a " + animal.getClassName() + ", but he ran away out of fear.";
		}else {
			return "- You meet a " + animal.getClassName() + " called " + animal.getName() + "\n" +
			user.getName() + ": " + user.meetReaction() + "\n" + animal.getClassName() + ": " + animal.meetReaction();
		}
	}
}
