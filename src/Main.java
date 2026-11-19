package src;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    static void main(String[] arg) {
        CoffeeMachine machine = new CoffeeMachine();

        while (true) {
            System.out.println(
                    "Write action (buy, fill, take, remaining, clean, exit):"
            );

            String action = input.nextLine().trim().toLowerCase();

            switch (action) {
                case "buy" -> buyCoffee(machine);
                case "fill" -> fillMachine(machine);
                case "take" -> machine.takeEarnings();
                case "remaining" -> machine.printResources();
                case "clean" -> machine.clean();
                case "exit" -> {
                    input.close();
                    return;
                }
                default -> System.out.println("Invalid action!");
            }
        }
    }

    private static void buyCoffee(CoffeeMachine machine) {
        System.out.println(
                "What do you want to buy? " +
                        "1 - espresso, 2 - latte, 3 - cappuccino, back - main menu:"
        );

        String choice = input.nextLine().trim().toLowerCase();

        if (choice.equals("back")) {
            return;
        }

        Coffee coffee = Coffee.getCoffee(choice);
        machine.buyCoffee(coffee);
    }

    private static void fillMachine(CoffeeMachine machine) {
        System.out.println("Write how many ml of water to add:");
        int water = input.nextInt();

        System.out.println("Write how many ml of milk to add:");
        int milk = input.nextInt();

        System.out.println("Write how many grams of coffee beans to add:");
        int beans = input.nextInt();

        System.out.println("Write how many disposable cups to add:");
        int cups = input.nextInt();

        input.nextLine();

        machine.fill(water, milk, beans, cups);
    }
}