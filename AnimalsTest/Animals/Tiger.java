package Animals;

import Base.Animal;
import Base.Feline;

import java.util.*;

public class Tiger extends Feline {
	private static String call = "rawr";

	public Tiger(String name) throws Exception {
		super(name, call);
	}

	public Tiger(String name, Class<? extends Animal> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
	}

	public Tiger(String name, Collection<Class<? extends Animal>> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
	}

	@Override
	public String meetReaction() {
		return getCall() + " the name's " + getName() + " *growls*";
	}
}
