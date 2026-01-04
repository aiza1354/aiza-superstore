import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Math;

public class Manager extends Person {
    // in case we need to change the variable, it is available at one place + constant
    private static final double elasticDiscount = 0.20;
    private static final double inelasticMarkup = 0.20;
    private static final double minimumPrice = 0.50;
    private static final String elastic = "Elastic";
    private static final String inelastic = "Inelastic";

    public Manager(String name, int age, String gender) {
        super(name, age, gender);
    }

    // create method that will add product to the shelf
    public void addProductToShelf(Product product, ArrayList<Product> shelf) {
        shelf.add(product);
    }
    //TODO: Move these functionalities to product class

    // if the quantity of a product bought falls below __
    // then you decrease the price if it is elastic (luxury / steak).
    // if you see that an item that is being bought profusely,
    // you increase the price if it is inelastic (necessary/addictive substance/bread).

    public void addProductHistory(ProductDetails productDetails,
                                  ArrayList<ProductDetails> productHistory) {
        productHistory.add(productDetails);
    }

    /// product is the variable assigned to the item we are calculating the PED
    public double calculatePED(ArrayList<ProductDetails> productHistory, Product product) {
        // % change in quantity =
        // // day 2 bread PED =  day 2 price - day 1 price / day 1  x 100
        // % change in quantity / % change in price


        //TODO: Sort the array by day for each product(WHY???)
        //TODO: Expand this logic to more than one Item
        // Find all productHistory of particular product, this will return arraylist
        // then sort the arraylist by day

        try {
            ArrayList<ProductDetails> currentProductHistory = new ArrayList<>();
            for (int i = 0; i < productHistory.size(); i++) {
                ProductDetails currentProductDetails = productHistory.get(i);
                if (currentProductDetails.getProductId() == product.getId()) {
                    currentProductHistory.add(currentProductDetails);
                }
            }
            if (currentProductHistory.size() < 2) {
                return 0.0;
            }
            //Sort the currentProductHistory arrayList
            currentProductHistory.sort(Comparator.comparingInt(a -> a.getDay()));

            double currentPrice = currentProductHistory.get(currentProductHistory.size() - 1).getPriceAtTime();
            double previousPrice = currentProductHistory.get(currentProductHistory.size() - 2).getPriceAtTime();

            double currentQuantitySold = currentProductHistory.get(currentProductHistory.size() - 1).getQuantitySold();
            double previousQuantitySold = currentProductHistory.get(currentProductHistory.size() - 2).getQuantitySold();

            double changeInPrice = ((currentPrice - previousPrice) / previousPrice) * 100;
            double changeInQuantitySold = ((currentQuantitySold - previousQuantitySold) / previousQuantitySold) * 100;

            return changeInQuantitySold / changeInPrice;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    // Parameters : 2 ArrayLists, productHistory  (of Product Details)
    // Shelf (made of Product (s))
    // We loop through shelf, because PH only exists if a product exists in shelf
    // (dependent on shelf)
    // We are taking each product from "Shelf" and that is under the vairable displayProduct
    // We take all the productDetails from Ph and assign it under latest
    // (we
    public void displayShelf(ArrayList<ProductDetails> productHistory,
                             ArrayList<Product> shelf) {
        try {
            for (int i = 0; i < shelf.size(); i++) {
                Product displayProduct = shelf.get(i);

                double PEDOfItem = calculatePED(productHistory, displayProduct);
                String elasticity = findElasticity(PEDOfItem);
                ProductDetails latest = getLatestProductDetails(productHistory, displayProduct);
                System.out.print("Item: " + displayProduct.getName());
                if (latest != null) {
                    double autoAdjustedPrice = autoPriceAdjuster(elasticity, latest.getPriceAtTime());
                    // Add new item to productHistory
                    // create new productDetail
                    ProductDetails newProductDetails = new ProductDetails(latest.getProductId(),
                            latest.getDay() + 1, latest.getQuantitySold(), autoAdjustedPrice);
                    productHistory.add(newProductDetails);
                    System.out.println(" , Price: £" + latest.getPriceAtTime() + " , Sold: " + latest.getQuantitySold() + " , PED: " + PEDOfItem + " , Elasticity: " + elasticity + ", Auto adjusted price 👩🏽‍💼: £" + autoAdjustedPrice);
                } else {
                    System.out.println(" : No data.");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
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
    public ProductDetails getLatestProductDetails(ArrayList<ProductDetails> productHistory,
                                                  Product product) {
        try {
            for (int i = productHistory.size() - 1; i >= 0; i--) {
                ProductDetails current = productHistory.get(i);
                if (current.getProductId() == product.getId()) {
                    return current;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public String findElasticity(double PED) {
        double absolutePED = Math.abs(PED);
        if (absolutePED < 1) {
            return inelastic;
        } else if (absolutePED > 1) {
            return elastic;
        } else {
            return "Unit Elastic";
        }
    }
    // Create a function which auto-adjusts the price of an item, depending on its elasticity.
    // If Elastic and PED is negative (Law of demand: Price up = Quantity down)
    // Sales dropped significantly after price hike, let's lower it back
    // If it is Inelastic + necessity
    // Demand didn't drop much even if price changed, let's increase profit

    public double autoPriceAdjuster(String elasticity, double priceAtTime) {
        // find the latest price of a product, find its inelasticity, and change price in ProductH
        double adjustedPrice;
        if (elasticity.equals(elastic)) {
            adjustedPrice = (priceAtTime - (priceAtTime * elasticDiscount));
        } else if (elasticity.equals(inelastic)) {
            adjustedPrice = (priceAtTime + (priceAtTime * inelasticMarkup));
        } else {
            return priceAtTime;
        }
        // check min value after autoPrice adjustment
        if (adjustedPrice < minimumPrice) {
            adjustedPrice = minimumPrice;
        }
        return adjustedPrice;
    }
}

