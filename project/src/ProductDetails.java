public class ProductDetails {
    private int productId;
    private int day;
    private int quantitySold;
    private double priceAtTime;
    /// TODO: Make the above attributes private and add getter and setters

    public ProductDetails(int productId, int day, int quantitySold, double priceAtTime) {
        this.productId = productId;
        this.day = day;
        this.quantitySold = quantitySold;
        this.priceAtTime = priceAtTime;
    }

    public int getProductId(){
        return productId;
    }

    public int getDay(){
        return day;
    }

    public int getQuantitySold(){
        return quantitySold;
    }

    public double getPriceAtTime(){
        return priceAtTime;
    }
}
