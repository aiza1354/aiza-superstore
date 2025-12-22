import java.util.ArrayList;

public class Manager {
    String name;
    int age;

    public Manager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // create method that will add product to the shelf
    public void addProductToShelf(Product product, ArrayList<Product> shelf){
        shelf.add(product);
        System.out.println("This is the size of the shelf: " + shelf.size());
    }
}

