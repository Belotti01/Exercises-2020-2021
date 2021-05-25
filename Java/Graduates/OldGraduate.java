public class OldGraduate extends Graduate {
	public final int maxGrade = 60;

	public OldGraduate(String name, int grade) throws Exception {
		super(name);
		setGrade(grade);
	}

	public void setGrade(int grade) throws Exception {
		if(grade < 36 || grade > 60) throw new Exception("An Old Graduate's grade must be between 36 and 60.");
		this.grade = grade;
	}

	public boolean isEligibleForExam() {
		return grade >= 42;
	}

	public String toString() {
		return "[Old] " + name + ": " + getGrade() + "/60" + maxGrade + (isEligibleForExam() ? ". " : ". Not ") + "Eligible for exam.";
	}

	public Graduate copy() throws Exception {
		return new OldGraduate(name, grade);
	}
	
}
