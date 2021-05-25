public class main {
    public static void main(String[] args) {
        Answer[] as1 = new Answer[4];
        Answer[] as2 = new Answer[4];
        Question qs[] = new Question[2];
        Test test;

        try {
            as1[0] = new Answer("A1", 0);
            as1[1] = new Answer("A2", 1);
            as1[2] = new Answer("A3", -1);
            as1[3] = new Answer("A4", 0);
            
            as2[0] = new Answer("A1", 0);
            as2[1] = new Answer("A2", 1);
            as2[2] = new Answer("A3", -1);
            as2[3] = new Answer("A4", 0);

            qs[0] = new Question("Question 1", as1);
            qs[1] = new Question("Question 2", as2);

            test = new Test();
            test.addQuestions(qs);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
