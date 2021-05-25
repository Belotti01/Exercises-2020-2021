package Animals;

import Base.*;

import java.util.*;

public class Wolf extends Canid {
	private static String call = "awoo";

	public Wolf(String name) throws Exception {
		super(name, call);
		addToFearedList(Tiger.class);
	}

	public Wolf(String name, Class<? extends Animal> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
		addToFearedList(Tiger.class);
	}

	public Wolf(String name, Collection<Class<? extends Animal>> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
		addToFearedList(Tiger.class);
	}

	@Override
	public String meetReaction() {
		return getCall() + " I'm called " + getName() + " *howls*";
	}
}
