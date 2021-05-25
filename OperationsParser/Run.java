import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		try {
			Parser p = new Parser(scn.nextLine());
			System.out.println("Result: " + p.getResult());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		scn.close();
	}
}