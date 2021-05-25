import java.util.*;

public class Parser {
	private static int result;
	private static symbol lastSymbol; 
	private enum symbol {
		number,
		parenthesis,
		operand
	}
	private static final char[] SIGNS = new char[] {
		'+', '-', 'x', '*', ':', '/'
	};
	private static String input;
	private static int index;
	private static Stack<Integer> operands;
	private static Stack<Operation> operations;
	private static Stack<Character> parenthesis;
	private static HashMap<Character, Character> parenthesisMap;
	
	private void Log(String s) { System.out.println(s); }

	public int getResult() { return result; }

	public Parser(String input) throws Exception {
		Parser.input = input;
		parenthesisMap = new HashMap<Character, Character>();
		parenthesisMap.put('(', ')');
		parenthesisMap.put('[', ']');
		parenthesisMap.put('{', '}');
		do {
			Initialize();
			Solve();
		}while(operands.size() > 1);
		result = operands.pop();
	}

	private static void Initialize() {
		operands = new Stack<Integer>();
		operations = new Stack<Operation>();
		parenthesis = new Stack<Character>();
	}

	private static void Solve() throws Exception {
		for(index = 0; index < input.length(); index++) {
			char c = input.charAt(index);
			if(isNumber(c)) {
				PushOperand(c);
				lastSymbol = symbol.number;
			}else if(isParenthesis(c)) {
				HandleParenthesis(c);
				lastSymbol = symbol.parenthesis;
			}else if(isSign(c)) {
				PushOperation(c);
				lastSymbol = symbol.operand;
			}
		}
	}



	private static boolean isNumber(char c) {
		try{
			Integer.parseInt(c+"");
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	private static boolean isParenthesis(char c) {
		return parenthesisMap.containsKey(c) || parenthesisMap.containsValue(c);
	}

	private static boolean isSign(char c) {
		for(char sign : SIGNS) {
			if(c == sign) {
				return true;
			}
		}
		return false;
	}



	private static void PushOperand(char c) {
		var number = new StringBuilder();
		do{
			number.append(c);
			c = input.charAt(++index);
		}while(isNumber(c));
		index--;
		
		operands.push(Integer.parseInt(number.toString()));
	}

	private static void HandleParenthesis(char c) throws Exception {
		if(parenthesisMap.containsKey(c)) {
			parenthesis.push(c);
		}else {
			if(!parenthesisMap.get(parenthesis.pop()).equals(c)) {
				throw new Exception("Invalid parenthesis order or count.");
			}
		}
	}

	private static void PushOperation(char c) {
		Operation newOperation = new Operation(c, (byte)parenthesis.size());
		if(	(operations.size() == 1 && newOperation.isHighPriority())
			|| operations.peek().getOrderValue() < newOperation.getOrderValue()) {
				if(lastSymbol != symbol.parenthesis) {
					SolveOperation();
				}
		}
		operations.push(newOperation);
	}



	private static void SolveOperation() {
		int result = operations.pop().SolveFor(operands.pop(), operands.pop());
		operands.push(result);
	}



	private static class Operation {	//Useless outside of this Parser class
		private final char[] HIGH_PRIORITY = new char[] {
			':', '/', 'x', '*'
		};
		private final char sign;
		private final byte orderValue;

		public Operation(char sign, byte orderValue) {
			this.sign = sign;
			this.orderValue = isHighPriority() ? ++orderValue : orderValue;
		}

		public boolean isHighPriority() {
			for(char c : HIGH_PRIORITY) {
				if(c == sign) {
					return true;
				}
			}
			return false;
		}

		public byte getOrderValue() { return orderValue; }

		public int SolveFor(int op2, int op1) {
			switch(sign) {
				case '+':
					return op1 + op2;
				case '-':
					return op1 - op2;
				case '*':
				case 'x':
					return op1 * op2;
				case ':':
				case '/':
					return op1 / op2;
				default:
					return 0;
			}
		}
	}
}
