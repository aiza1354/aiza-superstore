public class Product {
    int id;
    String name;
    boolean isNecessity = true;
    Double price;

    public Product(int id, String name, boolean isNecessity, Double price) {
        this.id = id;
        this.name = name;
        this.isNecessity = isNecessity;
        this.price = price;
    }
}
