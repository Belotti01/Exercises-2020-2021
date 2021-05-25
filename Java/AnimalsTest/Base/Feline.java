package Base;

import java.util.*;

public abstract class Feline extends Animal {

	protected Feline(String name, String call) throws Exception{
		super(name, call);
	}
	
	protected Feline(String name, String call, Class<? extends Animal> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
	}
	
	protected Feline(String name, String call, Collection<Class<? extends Animal>> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
	}
}
