package coffemachine;

public class Methods {
    public static void showAmount(float amount) {
        System.out.println( "You have: " + amount);
    }

    public static void decrementAmount(float amount, float price) {
        amount -= price;
    }

}


