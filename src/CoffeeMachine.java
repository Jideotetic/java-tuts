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

        printResources();

        String action = performAction();

        switch (action) {
            case "buy" -> {
                String type = selectTypeOfCoffee();
                buyCoffee(type);
            }
            case "fill" -> {
                addResources();
            }
            case "take" -> {
                takeEarnings();
            }
            default -> System.out.println("Invalid action");
        }

        printResources();
    }

    static void printResources() {
        System.out.println("The coffee machine has:\n" + water + " ml of water\n" + milk + " ml of milk\n" + beans + " g of beans\n" + disposableCups + " disposable cups\n" + "$" + earnings + " of money"
        );
    }

    static String performAction() {
        System.out.println("Write action (buy, fill, take): ");
        return input.nextLine();
    }

    static String selectTypeOfCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        return input.nextLine();
    }

    static void buyCoffee(@NotNull String typeOfCoffee) {
        switch (typeOfCoffee) {
            case "1" -> {
                if (hasEnoughResources(250, 0, 16)) {
                    System.out.println("Sorry, not enough resources!");
                    return;
                }
                water -= 250;
                beans -= 16;
                disposableCups--;
                earnings += 4;
            }
            case "2" -> {
                if (hasEnoughResources(350, 75, 20)) {
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
                if (hasEnoughResources(200, 100, 12)) {
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

    static boolean hasEnoughResources(int requiredWater, int requiredMilk, int requiredBeans) {
        return water < requiredWater || milk < requiredMilk || beans < requiredBeans || disposableCups < 1;
    }

    static void addResources() {

    }

    static void takeEarnings() {

    }
}
