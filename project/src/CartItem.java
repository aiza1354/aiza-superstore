public class CartItem {
    Product product;
    double currentPrice;
    int quantitySold;

    public CartItem(Product product, double currentPrice, int quantitySold) {
        this.product = product;
        this.currentPrice = currentPrice;
        this.quantitySold = quantitySold;
    }

}
