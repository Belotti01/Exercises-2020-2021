
public class Address {
    private String name, surname;
    private String prefix, tel;

    Address(String name, String surname, String fullTel) throws Exception {
        this.setNumber(fullTel);
        this.name = name;
        this.surname = surname;
    }

    Address(String name, String surname, String prefix, String tel) throws Exception {
        this.setPrefix(prefix);
        this.setNumber(tel);
        this.name = name;
        this.surname = surname;
    }

    Address(Address address) throws Exception {
        this(address.getName(), address.getSurname(), address.getFullNumber());
    }

    public Address copy() throws Exception {
        return new Address(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullNumber() {
        return (prefix.isEmpty() ? "" : "+" + prefix + " ") + tel;
    }

    public String getNumber() {
        return tel;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPrefix(String prefix) throws Exception{
        if(prefix.matches("\\d{1,3}")) {
            this.prefix = prefix;
        }else {
            throw new Exception("Invalid telephone prefix format");
        }
    }

    public void setNumber(String tel) throws Exception{
        //Find prefix in <tel>
        if(tel.matches("\\d{1,3}\\s\\d{10}")) {
            this.prefix = tel.split("\\s")[0];
            this.tel = tel.split("\\s")[1];
        }else if(tel.matches("\\d{10}")){
            this.prefix = "";
            this.tel = tel;
        }else {
            throw new Exception("Invalid telephone number format");
        }
    }

    public String stringify() {
        return this.getSurname() + " " + this.getName() + ": " + this.getFullNumber();
    }
}