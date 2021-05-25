import java.util.Scanner;
public class Main {
	private static Scanner scn;
	
	public static void main(String[] args) {
		int n = 0;
		Catalog catalog = new Catalog();
		
		System.out.println("enter the number of small appliances:");
		scn = new Scanner(System.in);
		n = scn.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.print("\nItem" + (i+1) + "\n\t- price: ");
			double price = fetchDoubleInput();
			System.out.print("\n\t- Category: ");
			String category = fetchInput();
			System.out.print("\n\t- Label: ");
			String label = fetchInput();
			System.out.print("\n\t- Energy Consumption: (W) ");
			double energyConsumption = fetchDoubleInput();
			try {
				catalog.addItem(new SmallAppliance(category, price, label, energyConsumption));
			}catch(Exception e) {
				System.out.println("\n" + e.getMessage());
			}
		}
		
		System.out.println("enter the number of big appliances:");
		scn = new Scanner(System.in);
		n = scn.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.print("\nItem" + (catalog.size()+1) + "\n\t- price: ");
			double price = fetchDoubleInput();
			System.out.print("\n\t- Category: ");
			String category = fetchInput();
			System.out.print("\n\t- model: ");
			String model = fetchInput();
			System.out.print("\n\t- Consumption Class: ");
			String consumptionClass = fetchInput();
			System.out.print("\n\t- Size: (m^2) ");
			double size = fetchDoubleInput();
			try {
				catalog.addItem(new BigAppliance(category, price, model, consumptionClass, size));
			}catch(Exception e) {
				System.out.println("\n" + e.getMessage());
			}
		}
		
		catalog.sort();
		while(true) {
			System.out.print("Enter:\n'S' to see all small appliances,\n'B' to see all big appliances,\n'A' to see all appliances\n'E' to exit");
			switch(Character.toUpperCase(fetchInput().charAt(0))) {
				case 'S':
					System.out.println(catalog.smallAppliancesString());
					break;
				case 'B':
					System.out.println(catalog.bigAppliancesString());
					break;
				case 'A':
					System.out.println(catalog.toString());
					break;
				case 'E':
					return;
				default:
					System.out.println("Invalid Command");
					break;
			}
		}
	}
	
	private static String fetchInput() {
		scn = new Scanner(System.in);
		return scn.nextLine();
	}
	
	private static double fetchDoubleInput() {
		scn = new Scanner(System.in);
		return scn.nextDouble();
	}
}