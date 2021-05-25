public class Answer {
    private String text;
    private int value;

    Answer(String text, int value) throws Exception{
        if(value != -1 && value != 0 && value != 1) throw new Exception("Invalid answer value.");
        this.text = text;
        this.value = value;
    }

    Answer(String text) {
        this.text = text;
        value = 0;
    }

    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }
}
