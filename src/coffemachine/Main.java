package coffemachine;

import java.util.Scanner;
import static coffemachine.Methods.showAmount;
import static coffemachine.Methods.refill;


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
        int sugar = 20;
        int milk = 20;
        refill(sugar, milk);
        System.out.println("Please enter amount: ");
        String password ="CoffeeMachine";
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
                            sugar = sugar - 5;
                            milk = milk - 5;
                            showAmount(amount);
                        }
                        case "cappuccino" -> {
                            amount -= 1;
                            sugar = sugar - 5;
                            milk = milk - 5;
                            showAmount(amount);
                        }
                        case "americano" -> {
                            amount -= 1.5f;
                            sugar = sugar - 5;
                            milk = milk - 5;
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
                case 5:
                    String pass = scanner.next();
                    if (pass.equals(password)) {
                        refill(20, 20);
                        sugar = 20;
                        milk = 20;
                    }
                default:
                    System.out.println("Wrong input");
                    break;
            }
            if (amount <= 0)
            {
                System.out.println("Sorry, you are out of money");
                work = false;
            }

            if (milk == 0 || sugar == 0)
            {
                System.out.println("Sorry, you are out of sugar or milk");
                System.out.println("You have to refill your machine");
                System.out.println("Please log in as administrator");
            }
        }
        scanner.close();
    }
}
