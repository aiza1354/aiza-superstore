public class ProductDetails {
    int day;
    int quantitySold;
    double priceAtTime;

    public ProductDetails (int day, int quantitySold, double priceAtTime){
      this.day = day;
      this.quantitySold = quantitySold;
      this.priceAtTime = priceAtTime;
    }

    public void calculatePED(){
        // PED = % change in price / % change in demand.
        // If between 0 and = inelastic
            // increase revenue = increase price
        // If between 1 and infinity = elastic
            // increase revenue = decrease price

    }

}
