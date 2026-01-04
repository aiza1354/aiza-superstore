public class Product {
    private static int counter = 1;

    private int id;
    private String name;
    private boolean isNecessity = true;
    private double price;
    private double currentPED;
    private String currentElasticity = "Unknown";

    // getter so that other classes can use ID etc. if needed
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getIsNecessity() {
        return isNecessity;
    }

    public double getPrice() {
        return price;
    }

    public Product(String name, boolean isNecessity, Double price) {
       // this automatically increments ID whenever a product is created.
        this.id = counter++;
        this.name = name;
        this.isNecessity = isNecessity;
        this.price = price;
    }



    // currentPed and currentElasticity as attribute

    public double getCurrentPED() {
        return currentPED;
    }

    public String getCurrentElasticity() {
        return currentElasticity;
    }

    public void setCurrentPED(double PED){
        this.currentPED = PED;
    }

    public void setCurrentElasticity(String elasticity){
        this.currentElasticity = elasticity;
    }

    public void setPrice(double autoAdjustedPrice){
        this.price = autoAdjustedPrice;
    }

    @Override
    public String toString (){
        return getId() + " " + getName() + " " + getIsNecessity() + " " + getPrice();
    }
}