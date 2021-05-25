package Base;

import java.util.*;

public abstract class Canid extends Animal {

	protected Canid(String name, String call) {
		super(name, call);
	}
	
	protected Canid(String name, String call, Class<? extends Animal> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
	}
	
	protected Canid(String name, String call, Collection<Class<? extends Animal>> isScaredOf) throws Exception {
		super(name, call, isScaredOf);
	}
}
