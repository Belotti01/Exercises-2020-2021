package Animals;

import Base.*;

import java.util.*;

public class Dog extends Canid {
	private static String call = "woof";

	public Dog(String name) throws Exception {
		super(name, call);
		addToFearedList(Tiger.class);
	}

	public Dog(String name, Class<? extends Animal> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
		addToFearedList(Tiger.class);
	}

	public Dog(String name, Collection<Class<? extends Animal>> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
		addToFearedList(Tiger.class);
	}

	@Override
	public String meetReaction() {
		return getCall() + " I'm " + getName() + " *waves tail*";
	}
}
