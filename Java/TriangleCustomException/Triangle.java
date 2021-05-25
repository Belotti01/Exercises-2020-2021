public class Triangle {
	double sides[];
	double height;

	public Triangle(double side1, double side2, double side3) throws InvalidSideLengthException {
		this.sides = new double[] {side1, side2, side3};
		for(double side : sides) {	//Throw custom Exception
			if(side <= 0) throw new InvalidSideLengthException(side);
		}
	}



	public double getSide(int index) throws IndexOutOfBoundsException {
		//Throws pre-implemented Exception
		return sides[index];
	}



	public double perimeter() {
		return sides[0] + sides[1] + sides[2];
	}

	public double area() throws Exception {
		double p = perimeter() / 2;
		double area = Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
		if(Double.isNaN(area)) {	//Throw generic exception with custom message
			throw new Exception("Value of area is not a number (" + area + ").");
		}
		return area;
	}
}