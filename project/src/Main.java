import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Shopper baba = new Shopper("Baba", "male", 24, true);
        Shopper aiza = new Shopper("Aiza", "female", 25, false);

        Product addictiveSubstance = new Product(1, "Addictive Substance", true, 20.50);
        Product bread = new Product(2, "Bread", true, 2.10);
        Product steak = new Product(3, " Steak", false, 10.50);

        ArrayList<Product> shelf = new ArrayList<>();
        Manager boss = new Manager("Boss", 78);
        boss.addProductToShelf(addictiveSubstance, shelf);
        boss.addProductToShelf(bread, shelf);
        boss.addProductToShelf(steak, shelf);
    }

}
