import java.util.ArrayList;

public class ProductDetails {
    int productId;
    int day;
    int quantitySold;
    double priceAtTime;

    public ProductDetails(int productId, int day, int quantitySold, double priceAtTime) {
        this.productId = productId;
        this.day = day;
        this.quantitySold = quantitySold;
        this.priceAtTime = priceAtTime;
    }
}
