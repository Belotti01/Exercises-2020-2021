public class Flat extends Abitation {
    public Flat() throws Exception {
        super();
    }

    public Flat(double price, double size) throws Exception {
        super(price, size);
    }

    public Flat(Abitation abitation) throws Exception {
        this(abitation.getPrice(), abitation.getSize());
    }

    @Override
    public Flat copy() throws Exception {
        return new Flat(price, size);
    }

    @Override
    public double pricePerSquareMeter() {
        return (double)Math.round(price / size * 100) / 100;
    }

    @Override
    public String toString() {
        return "Price: " + getPrice() +
        "\nSize: " + getSize() + " square meters" +
        "\nPrice per square-meter: " + pricePerSquareMeter();
    }
}
