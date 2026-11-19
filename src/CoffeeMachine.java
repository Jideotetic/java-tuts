package src;

import java.util.Scanner;

public class CoffeeMachine {
    static void main(String[] args) {
        final int waterForOneCupOfCoffee = 200;
        final int milkForOneCupOfCoffee = 50;
        final int gramsOfBeansForOneCupOfCoffee = 15;
        Scanner input = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterAvailable = input.nextInt();
        int numberOfCupsToMakeWithAvailableWater = waterAvailable / waterForOneCupOfCoffee;
        System.out.println(numberOfCupsToMakeWithAvailableWater);

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkAvailable = input.nextInt();
        int numberOfCupsToMakeWithAvailableMilk = milkAvailable / milkForOneCupOfCoffee;
        System.out.println(numberOfCupsToMakeWithAvailableMilk);

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeansAvailable = input.nextInt();
        int numberOfCupsToMakeWithAvailableCoffeeBeans = coffeeBeansAvailable / gramsOfBeansForOneCupOfCoffee;
        System.out.println(numberOfCupsToMakeWithAvailableCoffeeBeans);


        System.out.println("How many cups of coffee will you like: ");
        int numCoffeeCups = input.nextInt();

        int possibleCoffeeCups = Math.min(numberOfCupsToMakeWithAvailableWater, Math.min(numberOfCupsToMakeWithAvailableMilk, numberOfCupsToMakeWithAvailableCoffeeBeans));

        if(possibleCoffeeCups == numCoffeeCups){
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possibleCoffeeCups > numCoffeeCups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (possibleCoffeeCups - numCoffeeCups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + possibleCoffeeCups + " cup(s) of coffee");
        }

        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}
