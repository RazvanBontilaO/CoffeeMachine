package coffemachine;

import java.util.Scanner;
import static coffemachine.Methods.showAmount;

public class Main {
    public static void main(String[] args) {

        System.out.println("____Welcome to Coffee Machine____");
        System.out.println("_______________MENU______________");
        System.out.println("1. Coffee: Latte($2), Cappuccino($1), Americano($1.5)");
        System.out.println("2. Tea: Black tea($2), Green tea($2), Puerh tea($2)");
        System.out.println("3. Juice: Orange juice($3), Apple juice($2.5), Grape juice($2.5)");
        System.out.println("4. Exit");
        System.out.println("_________________________________");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter amount: ");
        float amount = scanner.nextFloat();
        showAmount(amount);

        boolean work = true;

        while (work) {
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You chose coffee");
                    System.out.println("Pick your drink: latte, cappuccino, americano");
                    String drink = scanner.next();
                    switch (drink.toLowerCase()) {
                        case "latte" -> {
                            amount -= 2;
                            showAmount(amount);
                        }
                        case "cappuccino" -> {
                            amount -= 1;
                            showAmount(amount);
                        }
                        case "americano" -> {
                            amount -= 1.5f;
                            showAmount(amount);
                        }
                        default -> System.out.println("Wrong input");
                    }
                    break;
                case 2:
                    System.out.println("You chose tea");
                    System.out.println("Pick your drink: black tea, green tea, puerh tea");
                    String tea = scanner.next();
                    switch (tea.toLowerCase()) {
                        case "black", "green", "puerh" -> {
                            amount -= 2;
                            showAmount(amount);
                        }
                        default -> System.out.println("Wrong input");
                    }
                    break;
                case 3:
                    System.out.println("You chose juice");
                    System.out.println("Pick your drink: orange juice, apple juice, grape juice");
                    String juice = scanner.next();
                    switch (juice.toLowerCase()) {
                        case "orange" -> {
                            amount -= 3;
                            showAmount(amount);
                        }
                        case "apple", "grape" -> {
                            amount -= 2.5f;
                            showAmount(amount);
                        }
                        default -> System.out.println("Wrong input");
                    }
                    break;
                    case 4:
                        System.out.println("Exiting...");
                        work = false;
                default:
                    System.out.println("Wrong input");
                    break;
            }
            if (amount <= 0)
            {
                System.out.println("Sorry, you are out of money");
                work = false;
            }
        }
    }
}
