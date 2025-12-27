import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Shopper baba = new Shopper("Baba", "male", 24, true);
        Shopper aiza = new Shopper("Aiza", "female", 25, false);

        Product addictiveSubstance = new Product( "Addictive Substance", true, 20.50);
        Product bread = new Product( "Bread", true, 2.10);
        Product steak = new Product( "Steak", false, 10.50);

        ArrayList<Product> shelf = new ArrayList<>();
        Manager storeManager = new Manager("Alex", 32);
        storeManager.addProductToShelf(addictiveSubstance, shelf);
        storeManager.addProductToShelf(bread, shelf);
        storeManager.addProductToShelf(steak, shelf);

        ArrayList<ProductDetails> productHistory = new ArrayList<>();
        ProductDetails breadDetailsDay1 = new ProductDetails(bread.id, 1, 4, bread.price);
        ProductDetails breadDetailsDay2 = new ProductDetails(bread.id, 2, 3, bread.price+0.5);

        storeManager.addProductHistory(breadDetailsDay1,productHistory);
        storeManager.addProductHistory(breadDetailsDay2,productHistory);

        storeManager.calculatePED(productHistory);
        storeManager.displayShelf(productHistory, shelf);

    }
}

