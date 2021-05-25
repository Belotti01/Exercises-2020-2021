package Base;

import java.lang.Character;
import java.util.*;

public abstract class Animal {
	protected static final String[] greetings = new String[] {
		"Hi", "Hello", "Greetings", "Good morning"
	};
	protected List<Class<? extends Animal>> isScaredOf = new ArrayList<Class<? extends Animal>>();
	protected String name;
	protected String call;



	protected Animal(String name, String call) {
		setName(name);
		setCall(call);
	}

	protected Animal(String name, String call, Collection<Class<? extends Animal>> isScaredOf) throws Exception {
		setName(name);
		setCall(call);
		addToFearedList(isScaredOf);
	}

	protected Animal(String name, String call, Class<? extends Animal> isScaredOf) throws Exception {
		setName(name);
		setCall(call);
		addToFearedList(isScaredOf);
	}



	public String getName() { 
		return name; 
	}
	public String getCall() {
		return call;
	}
	public void setName(String name) {
		this.name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
	}
	protected void setCall(String call) {
		this.call = call.toLowerCase();
	}
	public String getClassName() {
		return this.getClass().getName().substring(8);
	}



	protected void addToFearedList(Class<? extends Animal> animal) throws Exception {
		for(Class<? extends Animal> afraidOf : isScaredOf) {
			if(animal.isAssignableFrom(afraidOf)) {
				return;
			}else if(afraidOf.isAssignableFrom(animal) && !afraidOf.equals(animal)) {
				this.isScaredOf.remove(afraidOf);
				this.isScaredOf.add(animal);
				return;
			}
		}
		this.isScaredOf.add(animal);
	}

	protected void addToFearedList(Collection<Class<? extends Animal>> animals) throws Exception {
		for(Class<? extends Animal> animal : animals) {
			addToFearedList(animal);
		}
	}

	public String getRandomGreeting() {
		return Animal.greetings[new Random().nextInt(greetings.length)];
	}

	public boolean isScaredOf(Animal animal) {
		return isScaredOf(animal.getClass());
	}

	protected boolean isScaredOf(Class<? extends Animal> animal) {
		for (Class<? extends Animal> afraidOf : isScaredOf) {
			if(afraidOf.isAssignableFrom(animal)) {
				return true;
			}
		}
		return false;
	}

	public boolean isScaredOfAny(Collection<? extends Animal> animals) {
		for(Animal animal : animals) {
			for (Class<? extends Animal> afraidOf : isScaredOf) {
				if(animal.getClass().isAssignableFrom(afraidOf)) {
					return true;
				}
			}
		}
		return false;
	}

	public String getInfo() {
		return "Animal:\t" + getClassName() +
		"\nName:\t" + getName() +
		"\nCall:\t<<" + getCall() + ">>";
	}

	public abstract String meetReaction();
}