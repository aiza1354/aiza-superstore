import java.util.ArrayList;

public class Shopper extends Person{
    private boolean isLowIncome;
    ArrayList<CartItem> cart;

    public Shopper(String name, int age, String gender, boolean isLowIncome) {
        super(name, age, gender);
        this.isLowIncome = isLowIncome;
        this.cart = new ArrayList<>();
    }

    public boolean getIsLowIncome() {
        return isLowIncome;
    }

    public ArrayList<CartItem> addToCart(CartItem cartItem) {
        cart.add(cartItem);
        System.out.println(cartItem.product.getName() +" has been added to your cart 🛒.");
        return  cart;
    }

    public double calculateTotal(ArrayList<CartItem> cart) {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
        CartItem cartItem = cart.get(i);
            total += cartItem.currentPrice * cartItem.quantitySold;
        }
        System.out.println("Total value of your cart is: £"+ total + " 🍞");
        return total;
    }
}