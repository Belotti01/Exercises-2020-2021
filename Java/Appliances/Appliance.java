public abstract class Appliance implements Comparable<Appliance> {
	protected String category;
	protected double price;
	
	public Appliance(String category, double price) {
		this.category = category;
		this.price = Math.round(price * 100) / 100;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String toString() {
		return "- Category:\t" + category +
		"\n- Price:\t" + price;
	}

	public int compareTo(Appliance appliance) {
		return Double.compare(price, appliance.price);
	}
	
	public abstract double finalPrice();
}