public abstract class Graduate {
	protected String name;
	protected int grade;



	Graduate() {}

	Graduate(String name) throws Exception {
		setName(name);
	}

	Graduate(String name, int grade) throws Exception {
		if(grade < 36 || grade > 100) throw new Exception("A Graduate's grade must be between 36 and 100.");
		if(name.isBlank()) throw new Exception("A Graduate's name can't be blank or empty.");
		this.grade = grade;
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public void setName(String name) throws Exception {
		if(name.isBlank()) throw new Exception("A Graduate's name can't be blank or empty.");
		this.name = name;
	}



	public abstract Graduate copy() throws Exception;
	public abstract String toString();
	public abstract void setGrade(int grade) throws Exception;
	public abstract boolean isEligibleForExam();
}