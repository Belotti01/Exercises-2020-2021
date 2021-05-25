import java.util.*;

public class Main {
	private static Scanner scn;
	public static void main(String[] args) {
		var graduates = new GraduatesList();
		String[] input;
		int grade;
		System.out.println("Enter \"name - grade\"");
		try {
			do {
				System.out.print("- ");
				input = stringInput().split("\\s{0,}[-,]\\s{0,}");
				try {
					grade = Integer.parseInt(input[1]);
				}catch(NumberFormatException e) {
					throw new Exception("Grade must be a number.");
				}catch(Exception e) {
					break;
				}
				if(grade <= 60) {
					graduates.add(new OldGraduate(input[0], grade));
				}else {
					graduates.add(new NewGraduate(input[0], grade));
				}
			}while(input.length >= 2);

			if(graduates.size() == 0) throw new Exception("No graduates were registered.");
			graduates.sort();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println(graduates.toString());
		}
	}

	private static String stringInput() throws Exception {
		try {
			scn = new Scanner(System.in);
			return scn.nextLine();
		}catch(Exception e) {
			throw new Exception("Something went wrong while parsing your input.");
		}
	}
}
