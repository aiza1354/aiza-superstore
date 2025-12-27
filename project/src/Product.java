public class Product {
    int counter = 0;

    int id;
    String name;
    boolean isNecessity = true;
    Double price;

    public Product(String name, boolean isNecessity, Double price) {
       // this automatically increments ID whenever a product is created.
        this.id = counter++;
        this.name = name;
        this.isNecessity = isNecessity;
        this.price = price;
    }
}
