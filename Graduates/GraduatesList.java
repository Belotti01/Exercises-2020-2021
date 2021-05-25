import java.util.*;

public class GraduatesList {
	private List<Graduate> graduates = new ArrayList<Graduate>();

	GraduatesList() {}

	public void add(Graduate graduate) {
		graduates.add(graduate);
	}

	public Graduate get(int index) {
		return graduates.get(index);
	}

	public void sort() {
		graduates.sort((Graduate g1, Graduate g2) -> g1.getName().compareTo(g2.getName()));
	}

	public int size() {
		return graduates.size();
	}

	public String toString() {
		var str = "";
		for(Graduate g : graduates) {
			str += g.toString() + "\n";
		}
		return str;
	}
}
