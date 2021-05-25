import java.util.*;

public class Question {
	private String text;
	private List<Answer> answers;

	public Question(String text, List<Answer> answers) {
		this.text = text;
		this.answers = answers;
	}

	public Answer getAnswer(int index) {
		return answers.get(index);
	}

	public int getScore(int answerNumber) {
		return answers.get(answerNumber-1).getScore();
	}

	public int answersCount() {
		return answers.size();
	}

	public String toString() {
		var str = new StringBuilder();
		str.append(text);
		for(int i = 0; i < answers.size(); i++) {
			str.append("\n\t" + (i+1) + answers.get(i));
		}
		return str.toString();
	}
}
