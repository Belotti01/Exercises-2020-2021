import java.util.EmptyStackException;

public class test {
	public static void main(String[] args) throws Exception {
		int amountOfTests = 250;	// :^)
		//Test significativi:
		//- size < 2
		//- size == 2
		//- size > 2
		//
		//Test significativi che ho evitato per la mia sanità mentale:
		//- size == Integer.MAX_VALUE
		for(int i = 0; i < amountOfTests; i++) {
			StrangeStackTest(i);
		}
		/*
		System.out.println("DYNAMIC:\nPosition:\tValue");
		DynamicStackTest();
		
		System.out.println("\nSTATIC:\nPosition:\tValue");
		StaticStackTest();
		
		NormalStackTest();
		*/
	}
	
	private static void StrangeStackTest(int size) {
		NormalStack stack = new NormalStack();
		try {
			for(int i = 0; i <= size; i++) {
				stack.push(i);
			}
			System.out.println("Size:\t" + stack.size());
			System.out.println("Stack:\t" + stack.toString());		
			System.out.println("One-to-last value:\t" + stack.popOneToLast());
			System.out.println("Updated Stack:\t" + stack.toString() + "\n");	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
/*
	private static void DynamicStackTest() {
		NoHeadDynamicStack stack = new NoHeadDynamicStack(0);

		for(int i = 1; i < 10; i++) {
			stack.push(i);
		}

		while(stack.getSize() != 0) {
			System.out.println(stack.getSize() + ":\t\t" + stack.pop());
		}
	}

	private static void StaticStackTest() {
		StaticStack stack = new StaticStack(20, 0);

		for(int i = 1; i < 10; i++) {
			stack.push(i);
		}

		try {
			while(stack.size() != 0) {
				System.out.println(stack.size() + ":\t\t" + stack.pop());
			}
		}catch(EmptyStackException e) {
			System.out.println("\n\n[!] " + e.getMessage());
		}
	}

	private static void NormalStackTest() {
		System.out.println("\nNORMAL:");
		NormalStack stack = new NormalStack();

		for(int i = 0; i < 10; i++) {
			stack.push(i);
		}

		System.out.println("Values: " + stack.toString());
		System.out.println("Search '5':\tPosition: " + stack.search(5));
		System.out.println("Search '15':\tPosition: " + stack.search(15));

		System.out.println("\nPosition:\tValue");
		try {
			while(!stack.empty()) {
				System.out.println(stack.size() + ":\t\t" + stack.pop());
			}
		}catch(EmptyStackException e) {
			System.out.println("\n\n[!] " + e.getMessage());
		}
	}
*/
}
