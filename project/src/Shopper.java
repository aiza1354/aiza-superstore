public class Shopper extends Person{
    boolean isLowIncome;

    public Shopper(String name, int age, String gender, boolean isLowIncome) {
        super(name, age, gender);
        this.isLowIncome = isLowIncome;
    }
}

