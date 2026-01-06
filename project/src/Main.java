import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Login as Manager
        // Add item to shelf

        // TODO: Inheritance	Use extends Person for Manager and Shopper.
        // TODO: Encapsulation	Use private variables and getters/setters in Product.
        // TODO: Overriding	Create a toString() method in Product to replace manual print statements.
        // TODO: Aggregation	Keep the shelf as an external list passed to the Manager.

        //setting up my super-store!!!

        // Made manager and shelf (which will ensure that you can displayProduct)
        Manager storeManager = new Manager("Alex", 32, "male");
        ArrayList<Product> shelf = new ArrayList<>();

        // made productHistory! and array which contains all the pastHistory of an item.
        // In order to track price History.
        ArrayList<ProductDetails> productHistory = new ArrayList<>();


        // created addictive substance, bread and steak (products)
        Product addictiveSubstance = new Product( "Addictive Substance", true, 20.50);
        Product bread = new Product( "Bread", true, 2.00);
        Product steak = new Product( "Steak", false, 10.50);

        // storeManager is calling the method addProductToShelf to add the products to the shelf
        storeManager.addProductToShelf(addictiveSubstance, shelf);
        storeManager.addProductToShelf(bread, shelf);
        storeManager.addProductToShelf(steak, shelf);

        // Created some ProductDetails for bread steak and unknown addictive substance
        // for day 1 + 2
        ProductDetails breadDetailsDay1 = new ProductDetails(bread.getId(), 1, 8, bread.getPrice());
        ProductDetails breadDetailsDay2 = new ProductDetails(bread.getId(), 2, 7, bread.getPrice()+0.5);
        ProductDetails steakDetailsDay1 = new ProductDetails(steak.getId(), 1, 4, steak.getPrice());
        ProductDetails steakDetailsDay2 = new ProductDetails(steak.getId(), 2, 6, steak.getPrice()-1);
        ProductDetails addictiveSubstanceDay1 = new ProductDetails (addictiveSubstance.getId(), 1, 5, 20.50);
        ProductDetails addictiveSubstanceDay2 = new ProductDetails(addictiveSubstance.getId(), 2, 4, 21.00);

        // storeManager calls the method addProductHistory to add all the details to the array
        storeManager.addProductHistory(breadDetailsDay1,productHistory);
        storeManager.addProductHistory(breadDetailsDay2,productHistory);
        storeManager.addProductHistory(steakDetailsDay1,productHistory);
        storeManager.addProductHistory(steakDetailsDay2,productHistory);
        storeManager.addProductHistory(addictiveSubstanceDay1, productHistory);
        storeManager.addProductHistory(addictiveSubstanceDay2, productHistory);

        for (int day = 3; day <= 10 ; day++) {
            //  store manager implements the adjustedPrice.
            System.out.println("\n" + "             DAY " + day);
            storeManager.implementAdjustedPrice(productHistory, shelf);


            // store manager calls the method display shelf to showcase what is in the shelf (at the end of the day)
            // to make sure that they only have the updated prices NOT the old ones 👌🏽.
            storeManager.displayShelf(shelf);

            // Add the item to the cart
        /*CartItem cartItem1 = new CartItem(bread ,6);
        CartItem cartItem2 = new CartItem(steak,2);

        // created 2 shoppers 👨.
        Shopper baba = new Shopper("Bunty", 56, "male", true);
        Shopper aiza = new Shopper("Aiza", 16, "female", false );

        // i m adding a few items to my cart.
        aiza.addToCart(cartItem1);
        aiza.addToCart(cartItem2);

        // Calculate the total
        aiza.calculateTotal(aiza.cart);*/
            Shopper himawari = new Shopper("Himawari", 3, "male", true);
            Shopper aiza = new Shopper("Aiza", 16, "female", false);
            Shopper shinchan = new Shopper("Shinchan", 6, "male", false);
            ArrayList<Shopper> shoppersToday = new ArrayList<>();
            shoppersToday.add(himawari);
            shoppersToday.add(aiza);
            shoppersToday.add(shinchan);

            // looping through the customers.
            for (int i = 0; i < shoppersToday.size(); i++) {
                Shopper s = shoppersToday.get(i);
                System.out.println("This is " + s.name +"'s cart 🍏." );
                s.addToCart(new CartItem(bread, 2));
                s.addToCart(new CartItem(addictiveSubstance, 1));

                if (steak.getPrice() < 12.00 && !s.getIsLowIncome()) {
                    s.addToCart(new CartItem(steak, 1));
                }
            }

            System.out.println("\nTill is now closed. Displaying History!");
            for (int i = 0; i < shelf.size(); i++) {
                Product product = shelf.get(i);
                int totalBoughtToday = 0;
                for (int j = 0; j < shoppersToday.size(); j++) {
                    Shopper s = shoppersToday.get(j);
                    ArrayList<CartItem> cart = s.cart;
                    for (int k = 0; k < cart.size(); k++) {
                        CartItem item = cart.get(k); // Accessing cart list
                        if (item.product.getId() == product.getId()) {
                            totalBoughtToday += item.quantityBought;
                        }
                    }
                }

                // Add this day's performance to the history list
                ProductDetails productPerformanceByDay = new ProductDetails(product.getId(), day, totalBoughtToday, product.getPrice());
                storeManager.addProductHistory(productPerformanceByDay, productHistory);

                System.out.println("Item: " + product.getName() + ", Bought: " + totalBoughtToday + ", Price: £" + product.getPrice());
            }

        }

    }
}

