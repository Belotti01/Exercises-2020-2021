public class Product {
    static private ArrayList<Product> products = new ArrayList<Product>();

    private String name, brand;
    private double price;

    //Constructors
    Product() {
        name = "";
        brand = "default";
        price = 0;
        registerProduct();
    }

    Product(Product product) {
        name = product.getName();
        brand = product.getBrand();
        price = product.getPrice();
        registerProduct();
    }

    Product(String name, String brand) {
        this.name = name;
        this.brand = brand;
        price = 0;
        registerProduct();
    }

    Product(String name, double price) {
        this.name = name;
        this.brand = "default";
        this.price = price;
        registerProduct();
    }

    Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = Math.ceil(price * 100) / 100;
        registerProduct();
    }

    //Equals
    public boolean equals(Product product) {
        return product.getName().equals(name) && product.getBrand().equals(brand) && product.getPrice() == price;
    }

    //Copy
    public Product copy() {
        return new Product(this);
    }

    //<get> Methods
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    //<set> Methods
    public void setName(String newName) {
        name = newName;
    }

    public void setBrand(String newBrand) {
        brand = newBrand;
    }

    public void setPrice(double newPrice) {
        price =  Math.ceil(newPrice * 100) / 100;
    }

    //Methods
    private void registerProduct() {
        if(!products.contains(this)) {
            products.add(this);
        }
    }

    public void incrementPrice(double increment) {
        price += Math.ceil(increment * 100) / 100;
    }

    public void incrementPricePercent(int percentage) {
        price = price / 100 * (100 + percentage);
    }

    public void decrementPrice(double decrement) {
        price -= Math.ceil(decrement * 100) / 100;
    }

    public void decrementPricePercent(int percentage) {
        price = price / 100 * (100 - percentage);
        price = Math.round(price * 100) / 100;
    }

}