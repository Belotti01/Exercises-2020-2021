import java.util.*;

public class Catalog {
	private List<Appliance> entries;
	
	public Catalog() {
		entries = new ArrayList<Appliance>();
	}
	
	public void addItem(Appliance appliance) throws Exception {
		if(entries.contains(appliance)) {
			throw new Exception("The appliance\t" + appliance.toString() + "\nis already included in the catalog");
		}else {
			entries.add(appliance);
		}
	}
	
	public Appliance get(int index) throws IndexOutOfBoundsException {
		return entries.get(index);
	}

	public int size() {
		return entries.size();
	}
	
	public int length() {
		return entries.size();
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < entries.size(); i++) {
			str.append(entries.get(i).toString());
			str.append('\n');
		}
		return str.toString();
	}	
	
	public void sort() {
		entries.sort((Appliance x, Appliance y) -> x.compareTo(y));
	}	
	
	public String bigAppliancesString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < entries.size(); i++) {
			if(entries.get(i) instanceof BigAppliance) {
				str.append(entries.get(i).toString());
				str.append('\n');
			}
		}
		return str.toString();
	}	
	
	public String smallAppliancesString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < entries.size(); i++) {
			if(entries.get(i) instanceof SmallAppliance) {
				str.append(entries.get(i).toString());
				str.append('\n');
			}
		}
		return str.toString();
	}
}