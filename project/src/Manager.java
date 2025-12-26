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
    }


