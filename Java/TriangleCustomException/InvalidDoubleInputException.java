public class InvalidDoubleInputException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidDoubleInputException(String input) {
		super("The value \"" + input + "\" isn't a valid input of type double.");
	}
}
