import java.util.*;

public class BadExample {
	private static Stack<Character> stack = new Stack<Character>();
	private static Scanner scn = new Scanner(System.in);
	private static Map<Character, Character> map;

	public static void main(String[] javaBad) throws Exception {
		map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		System.out.print("Input: ");
		String input = scn.nextLine();

		for(int i = 0; i < input.length(); i++) {
			TestChar(input.charAt(i));
		}

		if(!stack.empty()) {
			throw new Exception("Invalid input parenthesis.");
		}

		System.out.println("Input is acceptable.");
	}

	private static void TestChar(Character c) throws Exception {
		System.out.println(stack.toString());
		if(map.containsKey(c)) {
			stack.push(c);
		}else if(map.containsValue(c)) {
			if(stack.empty() || !c.equals(map.get(stack.pop()))) {
				throw new Exception("Invalid input parenthesis.");
			}
		}
	}
}