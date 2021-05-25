import java.util.Scanner;

public class Main {
	private static Scanner scn;

	public static void main(String[] args) {
		Triangle triangle;

		System.out.println("- Enter the values of each side of the triangle:");
		
		try {
			triangle = new Triangle(DoubleInput(), DoubleInput(), DoubleInput());
		}catch(InvalidDoubleInputException e) {	//Custom Exception
			System.out.println(e.getMessage());
			return;
		}catch(InvalidSideLengthException e) { 	//Another custom Exception
			System.out.println(e.getMessage());
			return;
		}

		StringBuilder output = new StringBuilder();
		try {
			output.append("\n\n\t<-- Triangle -->\n\t< Sides >\n");
			for(int i = 0; i < 3; i++) {
				output.append(triangle.getSide(0) + "\t");
			}
			output.append("\n\t< Perimeter >\n\t" + triangle.perimeter() + "\n\t< Area >\n\t" + triangle.area());
		}catch(Exception e) {	//Generic Exception checked with instanceof
			if(e instanceof IndexOutOfBoundsException) {
				System.out.println(e.getMessage());
			}else {
				System.out.println("Unknown error: " + e.getMessage());
			}
			return;
		}
		System.out.println(output.toString());
	}



	private static double DoubleInput() throws InvalidDoubleInputException {
		scn = new Scanner(System.in);
		String input;
		System.out.print("> ");
		input = scn.nextLine();
		try {
			return Double.parseDouble(input);
		}catch(Exception e) {	//Generic Exception throws custom Exception
			throw new InvalidDoubleInputException(input);
		}
	}
}
