import java.lang.Math;

public abstract class Abitation {
    protected double price;
    protected double size;

    public Abitation() throws Exception {
        this(0, 1);
    }

    public Abitation(double price, double size) throws Exception {
        setPrice(price);
        setSize(size);
    }

    public Abitation(Abitation abitation) throws Exception {
        this(abitation.getPrice(), abitation.getSize());
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if(price < 0) throw new Exception("Price can't be lower than 0.");
        price = Math.round(price * 100) / 100;
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    protected void setSize(double size) throws Exception {
        if(size <= 0) throw new Exception("Size must be greater than 0.");
        this.size = size; 
    }
    
    public abstract Abitation copy() throws Exception;
    public abstract double pricePerSquareMeter();
    public abstract String toString();
}
