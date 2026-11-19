package src;

import java.util.Scanner;

public class CoffeeMachine {
    static void main(String[] args) {
        final int waterPerCup = 200;
        final int milkPerCup = 50;
        final int beansPerCup = 15;
        Scanner input = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = input.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = input.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beans = input.nextInt();
        System.out.println("How many cups of coffee will you like: ");
        int cups = input.nextInt();

        int possible = Math.min(water / waterPerCup, Math.min(milk / milkPerCup, beans / beansPerCup));

        if(possible == cups){
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possible > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (possible - cups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + possible + " cup(s) of coffee");
        }
    }
}
