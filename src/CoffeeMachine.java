package src;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner input = new Scanner(System.in);

    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int disposableCups = 9;
    private static int earnings = 550;

    static void main(String[] args) {

        while (true) {
            printResources();
            String action = performAction();

            if (action.equals("exit")) {
                break;
            }

            switch (action) {
                case "buy" -> buyCoffee(selectTypeOfCoffee());
                case "fill" -> addResources();
                case "take" -> takeEarnings();
                default -> System.out.println("Invalid action");
            }
        }


        input.close();
    }

    static void printResources() {
        System.out.println("The coffee machine has:\n" + water + " ml of water\n" + milk + " ml of milk\n" + beans + " g of beans\n" + disposableCups + " disposable cups\n" + "$" + earnings + " of money"
        );
    }

    static String performAction() {
        System.out.println("Write action (buy, fill, take, exit): ");
        return input.nextLine();
    }

    static String selectTypeOfCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        return input.nextLine();
    }

    static void buyCoffee(@NotNull String typeOfCoffee) {
        switch (typeOfCoffee) {
            case "1" -> {
                if (hasLessResources(250, 0, 16)) {
                    System.out.println("Sorry, not enough resources!");
                    return;
                }
                water -= 250;
                beans -= 16;
                disposableCups--;
                earnings += 4;
            }
            case "2" -> {
                if (hasLessResources(350, 75, 20)) {
                    System.out.println("Sorry, not enough resources!");
                    return;
                }
                water -= 350;
                milk -= 75;
                beans -= 20;
                disposableCups--;
                earnings += 7;
            }
            case "3" -> {
                if (hasLessResources(200, 100, 12)) {
                    System.out.println("Sorry, not enough resources!");
                    return;
                }
                water -= 200;
                milk -= 100;
                beans -= 12;
                disposableCups--;
                earnings += 6;
            }
            default -> System.out.println("Invalid type");
        }
    }

    static boolean hasLessResources(int requiredWater, int requiredMilk, int requiredBeans) {
        return water < requiredWater || milk < requiredMilk || beans < requiredBeans || disposableCups < 1;
    }

    static void addResources() {
        System.out.println("How many ml of water to add: ");
        water += input.nextInt();

        System.out.println("How many ml of milk to add: ");
        milk += input.nextInt();

        System.out.println("How many beans to add: ");
        beans += input.nextInt();

        System.out.println("How many disposable cups to add: ");
        disposableCups += input.nextInt();

        input.nextLine();
    }

    static void takeEarnings() {
        if(earnings < 1) {
            System.out.println("No earnings!");
            return;
        }
        System.out.println("I gave you $" + earnings);
        earnings = 0;
    }
}
