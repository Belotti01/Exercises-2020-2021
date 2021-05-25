public class NewGraduate extends Graduate {
	public final int maxGrade = 100;

	public NewGraduate(String name, int grade) throws Exception {
		super(name);
		setGrade(grade);
	}

	public void setGrade(int grade) throws Exception {
		if(grade < 61 || grade > 100) throw new Exception("A New Graduate's grade must be between 61 and 100.");
		this.grade = grade;
	}

	public boolean isEligibleForExam() {
		return grade >= 70;
	}

	public String toString() {
		return "[New] " + name + ": " + getGrade() + "/" + maxGrade + (isEligibleForExam() ? ". " : ". Not ") + "Eligible for exam.";
	}

	public Graduate copy() throws Exception{
		return new NewGraduate(name, grade);
	}
}
