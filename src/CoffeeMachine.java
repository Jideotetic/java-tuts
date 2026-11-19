package src;

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

            String action = performAction();

            if (action.equals("exit")) {
                break;
            }

            switch (action) {
                case "buy" -> buyCoffee(selectTypeOfCoffee());
                case "fill" -> addResources();
                case "take" -> takeEarnings();
                case "remaining" -> printResources();
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
        System.out.println("Write action (buy, fill, take, exit, remaining): ");
        return input.nextLine().trim().toLowerCase();
    }

    static String selectTypeOfCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back to main menu: ");
        return input.nextLine().trim().toLowerCase();
    }

    static void buyCoffee(String typeOfCoffee) {
        switch (typeOfCoffee) {
            case "1" -> makeCoffee(250, 0, 16, 4);
            case "2" -> makeCoffee(350, 75, 20, 7);
            case "3" -> makeCoffee(200, 100, 12, 6);
            case "back" -> System.out.println("Returning to main menu...");
            default -> System.out.println("Invalid type");
        }
    }

    static void makeCoffee(int requiredWater, int requiredMilk, int requiredBeans, int price) {
        String missingResource = checkResources(requiredWater, requiredMilk, requiredBeans);

        if (missingResource != null) {
            System.out.println("Sorry, not enough " + missingResource + "!");
            return;
        }

        water -= requiredWater;
        milk -= requiredMilk;
        beans -= requiredBeans;
        disposableCups--;
        earnings += price;

        System.out.println("I have enough resources, making you a coffee!");
    }

    static String checkResources(int requiredWater, int requiredMilk, int requiredBeans) {
        if (water < requiredWater) {
            return "water";
        }

        if (milk < requiredMilk) {
            return "milk";
        }

        if (beans < requiredBeans) {
            return "beans";
        }

        if (disposableCups < 1) {
            return "disposable cups";
        }

        return null;
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
        System.out.println("I gave you $" + earnings);
        earnings = 0;
    }
}
