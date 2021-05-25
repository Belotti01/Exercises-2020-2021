public class VacationHouse extends House {
	private int distanceFromSea;

	public VacationHouse() throws Exception {
		super(0, 1);
		distanceFromSea = 0;
	}

	public VacationHouse(double finalPrice, double size) throws Exception {
		super(finalPrice, size);
		distanceFromSea = 0;
	}

	public VacationHouse(double finalPrice, double size, int distanceFromSea) throws Exception {
		super(finalPrice, size);
		this.distanceFromSea = distanceFromSea;
	}

	public int getDistanceFromSea() {
		return distanceFromSea;
	}

	public double getBasePrice() {
		var basePrice = price;
		for(int i = 100; i <= distanceFromSea; i += 100) {
			basePrice *= 10/9;
		}
		return basePrice;
	}

	public void setDistanceFromSea(int distanceFromSea) {
		var finalPrice = this.getBasePrice();
		for(int i = 100; i <= distanceFromSea; i += 100) {
			finalPrice *= 9/10;
		}
		this.distanceFromSea = distanceFromSea;
		this.price = finalPrice;
	}

	@Override
    public String toString() {
		return super.toString() +
		"\nDistance from the sea: " + distanceFromSea + "m";
    }
}
