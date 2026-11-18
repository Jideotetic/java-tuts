package src;

import java.util.Scanner;

public class CoffeeMachine {
    static void main(String[] args) {
        System.out.println("Starting to make a coffee");

        Scanner input = new Scanner(System.in);
        System.out.println("How many cups of coffee will you like: ");
        int numCoffeeCups = input.nextInt();

        long mlOfWater = numCoffeeCups * 200L;
        long mlOfMilk = numCoffeeCups * 50L;
        long gramsOfCoffeeBeans = numCoffeeCups * 15L;

        System.out.println("For " + numCoffeeCups + " cups of coffee you will need: ");
        System.out.println(mlOfWater + " ml of water");
        System.out.println(mlOfMilk + " ml of milk");
        System.out.println(gramsOfCoffeeBeans + " g of coffee beans");


        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}
