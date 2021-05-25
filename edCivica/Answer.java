public class Answer {
	private String text;
	private int score;
	
	public Answer(String text, int score) {
		this.text = text;
		this.score = score;
	}

	public String toString() {
		return text;
	}

	public int getScore() {
		return score;
	}
}