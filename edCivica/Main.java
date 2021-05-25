import java.util.*;
import java.util.stream.*;

public class Main {
	private static int[] scores;
	public static void main(String[] args) {
		var test = parseTest();
		if(test == null) return;

		startTest(test);
		printResults(test);

	}

	private static List<Category> parseTest() {
		var fp = new FileParser();
		try {
			return fp.parse("test.txt");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private static void startTest(List<Category> test) {
		scores = new int[test.size()];
		for(int c = 0; c < test.size(); c++) {
			var category = test.get(c);
			System.out.println("\n[ " + category.getName() + " ]");
			for(int q = 0; q < category.size(); q++) {
				var question = category.getQuestion(q);
				System.out.print(question.toString());
				scores[c] += requestAnswer(question.answersCount());
			}
		}
	}

	private static int requestAnswer(int maxAnswer) {
		int answer;
		Scanner scn;
		do {
			scn = new Scanner(System.in);
			try {
				System.out.print("\n- Answer: ");
				answer = scn.nextInt();
			}catch(Exception e) {
				answer = -1;
			}
		}while (answer < 1 || answer > maxAnswer);
		scn.close();
		return answer;
	}

	private static void printResults(List<Category> test) {
		double totalScore = IntStream.of(scores).sum() / 300;
		System.out.println("\n\t[ RESULTS ]");
		for(int i = 0; i < scores.length; i++) {
			System.out.println(test.get(i).getName() + ":\t" + scores[i]);
		}
		System.out.println("\nFinal Score: " + totalScore);
	}
}
