import java.util.ArrayList;
import java.util.Collections;

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
    //TODO: Move these functionalities to product class

    // if the quantity of a product bought falls below __
    // then you decrease the price if it is elastic (luxury / steak).
    // if you see that an item that is being bought profusely,
    // you increase the price if it is inelastic (necessary/addictive substance/bread).

    public void addProductHistory (ProductDetails productDetails,
                ArrayList <ProductDetails> productHistory){
        productHistory.add(productDetails);
        }


    public void  calculatePED( ArrayList<ProductDetails> productHistory) {
        // % change in quantity =
        // // day 2 bread PED =  day 2 price - day 1 price / day 1  x 100
        // % change in quantity / % change in price


        //TODO: Sort the array by day for each product(WHY???)
        //TODO: Expand this logic to more than one Item

        double currentPrice = productHistory.get(productHistory.size() -1).priceAtTime;
        double previousPrice = productHistory.get(productHistory.size()-2).priceAtTime;


        double currentQuantitySold = productHistory.get(productHistory.size()-1).quantitySold;
        double previousQuantitySold = productHistory.get(productHistory.size()-2).quantitySold;

        double changeInPrice = ((currentPrice - previousPrice) / previousPrice) * 100;
        double changeInQuantitySold = ((currentQuantitySold - previousQuantitySold) / previousQuantitySold) * 100;

        double PED = changeInQuantitySold / changeInPrice;
            System.out.println("PED of bread = " + PED );
        }

    public void displayShelf(ArrayList<ProductDetails> productHistory, ArrayList<Product> shelf) {
        for (int i = 0; i < shelf.size(); i++) {
            Product displayProduct = shelf.get(i);
            ProductDetails latest =  getLatestProductDetails(productHistory,displayProduct );
            System.out.print("Item: " + displayProduct.name);
            if (latest != null) {
                System.out.println(" : Price: £" + latest.priceAtTime + " : Sold: " + latest.quantitySold);
            } else {
                System.out.println(" : No data.");
            }
        }

    }
    // we are getting the array list first of producthistory, which is made up of productDetails
    // we also get Product
    // we loop through product history backwards (hence, *i* is decreasing).
    // Then, from ProductDetails we choose a variable name, current tp get from PH.
    // If current.product id (which we get by looping through product history) matches the Product's product id
    // then we return the found product!
    // Otherwise, we return null
    // And + throw an exception if for e.g something crashes!
    public ProductDetails getLatestProductDetails(ArrayList<ProductDetails> productHistory, Product product) {
        try {
            for (int i = productHistory.size() - 1; i >= 0; i--) {
                ProductDetails current = productHistory.get(i);
                if (current.productId == product.id) {
                    return current;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}


