import java.util.*;

public class Category {
	private String name;
	private List<Question> questions;

	public Category(String name, List<Question> questions) {
		this.name = name;
		this.questions = questions;
	}

	public int totalScore(int ...answers) {
		int score = 0;
		for(int i = 0; i < questions.size(); i++) {
			score += questions.get(i).getAnswer(answers[i]).getScore();
		}
		return score;
	}

	public Question getQuestion(int index) {
		return questions.get(index);
	}

	public int size() {
		return questions.size();
	}

	public String getName() {
		return name;
	}
}
