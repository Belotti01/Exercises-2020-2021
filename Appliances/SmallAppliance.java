public class SmallAppliance extends Appliance {
	private double energyConsumption;
	private String label;
	
	public SmallAppliance(String category, double price, String label, double energyConsumption) {
		super(category, price);
		this.label = label;
		this.energyConsumption = Math.round(energyConsumption * 100) / 100;
	}
	
	public String getLabel() {
		return label;
	}
	
	public double getEnergyConsumption() {
		return energyConsumption;
	}
	
	public String toString() {
		return super.toString() +
		"\n- Final Price:\t" + finalPrice() +
		"\n- Label:\t" + label +
		"\n- Energy Consumption:\t" + energyConsumption + "W";
	}
	
	@Override
	public double finalPrice() {
		int overPrice = (int)(energyConsumption / 100);
		return Math.round(price / 100 * (100 + overPrice * 3) * 100) / 100;
	}
}