package Animals;

import Base.Animal;
import Base.Canid;
import Base.Feline;

import java.util.*;

public class Cat extends Feline{
	private static String call = "meow";

	public Cat(String name) throws Exception {
		super(name, call);
		addToFearedList(Canid.class);
	}

	public Cat(String name, Class<? extends Animal> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
		addToFearedList(Canid.class);
	}

	public Cat(String name, Collection<Class<? extends Animal>> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
		addToFearedList(Canid.class);
	}

	@Override
	public String meetReaction() {
		return getCall() + " my name is " + getName() + " *purr*";
	}
}
