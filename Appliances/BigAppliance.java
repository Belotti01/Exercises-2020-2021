public class BigAppliance extends Appliance {
	private String model;
	private String consumptionClass;
	private double size;
	
	public BigAppliance(String category, double price, String model, String consumptionClass, double size) {
		super(category, price);
		this.model = model;
		this.consumptionClass = consumptionClass;
		this.size = size;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getConsumptionClass() {
		return consumptionClass;
	}
	
	public double getSize() {
		return size;
	}
	
	@Override
	public double finalPrice() {
		int overPrice = 'A' - Character.toUpperCase(consumptionClass.charAt(0)) + 3 - (consumptionClass.length() - (consumptionClass.replaceAll("\\+", "")).length());
		return Math.round(price / 100 * (100 + overPrice * 5) * 100) / 100;
	}
	
	public String toString() {
		return super.toString() +
		"\n- Final price:" + finalPrice() +
		"\n- Model:\t" + model +
		"\n- Consumption Class:\t" + consumptionClass +
		"\n- Size:" + size + "m^2";
	}
}