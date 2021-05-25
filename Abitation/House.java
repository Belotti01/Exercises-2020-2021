public class House extends Abitation {
    private int floors;

    public House() throws Exception {
        super();
        floors = 1;
    }

    public House(double price, double size) throws Exception {
        super(price, size);
        floors = 1;
    }

    public House(double price, double size, int floors) throws Exception {
        super(price, size);
        setFloors(floors);
    }

    public House(House house) throws Exception {
        this(house.getPrice(), house.getSize(), house.getFloors());
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) throws Exception {
        if(floors <= 0) throw new Exception("Floors amount must be greater than 0.");
        this.floors = floors;
    }

    @Override
    public House copy() throws Exception {
        return new House(price, size, floors);
    }

    @Override
    public double pricePerSquareMeter() {
        return (double)Math.round(price / size / floors * 100) / 100;
    }

    @Override
    public String toString() {
        return "Price: " + getPrice() +
        "\nSize: " + getSize() + " square meters" +
        "\nFloors: " + getFloors() +
        "\nPrice per square-meter: " + pricePerSquareMeter();
    }
}
