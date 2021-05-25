import java.util.*;

public class Test {
    private List<Question> questions;
    
    Test(Question[] questions) throws Exception {
        this.questions = new ArrayList<Question>();
        addQuestions(questions);
    }

    Test(Question question) {
        this.questions = new ArrayList<Question>();
        addQuestion(question);
    }

    Test() {
        this.questions = new ArrayList<Question>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addQuestions(Question[] questions) {
        for(int i = 0; i < questions.length; i++) {
            this.questions.add(questions[i]);
        }
    }

    public int length() {
        return questions.size();
    }

    public Question getQuestion(int index) throws Exception {
        if(index < 0 || index > questions.size()) throw new IndexOutOfBoundsException();
        return questions.get(index);
    }
}
