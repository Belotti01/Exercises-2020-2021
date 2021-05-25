import java.util.*;

public class AddressBook {
    private List<Address> entries;
    private Address lastResult;

    AddressBook() {
        entries = new ArrayList<Address>();
    }

    AddressBook(Address address) {
        entries = new ArrayList<Address>();
        entries.add(address);
    }

    public void add(Address address) {
        entries.add(address);
    }

    public void remove(Address address) {
        entries.remove(address);
    }

    public int length() {
        return entries.size();
    }

    public Address findByName(String name) {
        String surname, finalName;

        if(name.contains(" ")) {
            finalName = name.split("\\s")[1];
            surname = name.split("\\s")[0];
        }else {
            finalName = name;
            surname = "";
        }

        entries.forEach((entry) -> {
            if(entry.getName().equalsIgnoreCase(finalName)) {
                if(entry.getSurname().equalsIgnoreCase(surname) || surname.isEmpty()) {
                    lastResult = entry;
                    return;
                }
            }else if(!surname.isEmpty() && entry.getName().equalsIgnoreCase(surname)) {
                if(entry.getSurname().equalsIgnoreCase(finalName)) {
                    lastResult = entry;
                    return;
                }
            }
        });
        return lastResult;
    }

    public Address findBySurname(String surname) {
        entries.forEach((entry) -> {
            if(entry.getSurname().equalsIgnoreCase(surname)) {
                lastResult = entry;
                return;
            }
        });
        return lastResult;
    }

    public Address findByNumber(String tel) {
        entries.forEach((entry) -> {
            if(entry.getNumber().equals(tel) || entry.getFullNumber().equals("+" + tel)) {
                lastResult = entry;
                return;
            }
        });
        return lastResult;
    }

    public String stringify() {
        String str = "";
        for(int i = 0; i < this.length(); i++) {
            str += "> " + entries.get(i).getSurname() + " " + entries.get(i).getName() + ": " + entries.get(i).getFullNumber() + "\n";
        }
        return str;
    }
}