public class InvalidSideLengthException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidSideLengthException(double side) {
		super("Sides of a triangle must be greater than 0; the value " + side + " isn't acceptable.");
	}
}
