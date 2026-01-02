import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Login as Manager
        // Add item to shelf

        // TODO: Inheritance	Use extends Person for Manager and Shopper.
        // TODO: Encapsulation	Use private variables and getters/setters in Product.
        // TODO: Overriding	Create a toString() method in Product to replace manual print statements.
        // TODO: Aggregation	Keep the shelf as an external list passed to the Manager.

        Shopper baba = new Shopper("Baba", 56, "male", true);
        Shopper aiza = new Shopper("Aiza", 16, "female", false);

        Product addictiveSubstance = new Product( "Addictive Substance", true, 20.50);
        Product bread = new Product( "Bread", true, 2.00);
        Product steak = new Product( "Steak", false, 10.50);


        ArrayList<Product> shelf = new ArrayList<>();
        Manager storeManager = new Manager("Alex", 32, "male");
        storeManager.addProductToShelf(addictiveSubstance, shelf);
        storeManager.addProductToShelf(bread, shelf);
        storeManager.addProductToShelf(steak, shelf);

        ArrayList<ProductDetails> productHistory = new ArrayList<>();
        ProductDetails breadDetailsDay1 = new ProductDetails(bread.getId(), 1, 8, bread.getPrice());
        ProductDetails breadDetailsDay2 = new ProductDetails(bread.getId(), 2, 7, bread.getPrice()+0.5);
        ProductDetails steakDetailsDay1 = new ProductDetails(steak.getId(), 1, 4, steak.getPrice());
        ProductDetails steakDetailsDay2 = new ProductDetails(steak.getId(), 2, 6, steak.getPrice()-1);

        storeManager.addProductHistory(breadDetailsDay1,productHistory);
        storeManager.addProductHistory(breadDetailsDay2,productHistory);
        storeManager.addProductHistory(steakDetailsDay1,productHistory);
        storeManager.addProductHistory(steakDetailsDay2,productHistory);
        storeManager.displayShelf(productHistory, shelf);

        // Get latest price of the item sold
        ProductDetails breadDetail = storeManager.getLatestProductDetails(productHistory, bread);
        // Add the item to the cart
        CartItem cartItem1 = new CartItem(bread, breadDetail.priceAtTime,2);
        CartItem cartItem2 = new CartItem(bread, breadDetail.priceAtTime,4);
        aiza.addToCart(cartItem1);
        aiza.addToCart(cartItem2);

        // Calculate the total
        aiza.calculateTotal(aiza.cart);
    }
}

