import java.lang.Math;

class Question {
    private String question;
    private Answer[] answers;

    Question(String question, Answer[] answers) throws Exception {
        if(question.isBlank()) throw new Exception("Invalid question String value; String is empty or blank.");
        if(answers.length != 4) throw new Exception("Invalid answers array length; the array must have 4 answers.");
        for(int i = 0; i < answers.length; i++) {
            if(answers[i].getValue() > 0) break;
            else if(i == answers.length - 1) throw new Exception("Invalid answers values; at least one answer must have a positive value."); 
        }
        this.question = question;
        this.answers = answers;
    }

    Question(String question, Answer answer1, Answer answer2, Answer answer3, Answer answer4) throws Exception {
        this(question, new Answer[] { answer1, answer2, answer3, answer4 });
    }

    public String getQuestion() {
        return question;
    }

    public Answer[] getAnswersInRandomOrder() {
        int random[] = new int[4];
        Answer[] randomlyOrderedAnswers = new Answer[4];
        int counter = 0;
        int pos = 0;
        
        for(int i = 0; i < 4; i++) random[i] = (int)Math.round(Math.random());

        while(counter < 4) {
            if(random[pos] == 1) {
                randomlyOrderedAnswers[pos] = answers[counter];
                counter ++;
            }
            pos++;
        }
        return randomlyOrderedAnswers;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public Answer getAnswer(int index) throws Exception {
        if(index < 0 || index > 3) throw new Exception("Invalid Answer index; Index must be a value between 0 and 3 inclusive.");
        return answers[index];
    }

    public boolean equals(Question question) {
        return question.question.equals(this.question);
    }
}