package src;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int disposableCups = 9;
    private int earnings = 550;

    private int coffeesMade = 0;
    private boolean cleaningRequired = false;

    public void buyCoffee(Coffee coffee) {
        if (cleaningRequired) {
            System.out.println("I need cleaning!");
            return;
        }

        if (coffee == null) {
            System.out.println("Invalid coffee type!");
            return;
        }

        String missingResource = checkResources(coffee);

        if (missingResource != null) {
            System.out.println("Sorry, not enough " + missingResource + "!");
            return;
        }

        water -= coffee.water();
        milk -= coffee.milk();
        beans -= coffee.beans();
        disposableCups--;
        earnings += coffee.cost();

        coffeesMade++;

        System.out.println("I have enough resources, making you a " + coffee.name() + "!");

        if (coffeesMade >= 10) {
            cleaningRequired = true;
            System.out.println("I need cleaning!");
        }
    }

    private String checkResources(Coffee coffee) {
        if (water < coffee.water()) {
            return "water";
        }

        if (milk < coffee.milk()) {
            return "milk";
        }

        if (beans < coffee.beans()) {
            return "beans";
        }

        if (disposableCups < 1) {
            return "disposable cups";
        }

        return null;
    }

    public void clean() {
        if (!cleaningRequired) {
            System.out.println("The machine doesn't need cleaning.");
            return;
        }

        coffeesMade = 0;
        cleaningRequired = false;

        System.out.println("I have been cleaned!");
    }

    public void fill(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.disposableCups += cups;

        System.out.println("The machine has been refilled!");
    }

    public void takeEarnings() {
        System.out.println("I gave you $" + earnings);
        earnings = 0;
    }

    public void printResources() {
        System.out.println(
                "The coffee machine has:\n" +
                        water + " ml of water\n" +
                        milk + " ml of milk\n" +
                        beans + " g of coffee beans\n" +
                        disposableCups + " disposable cups\n" +
                        "$" + earnings + " of money"
        );

        System.out.println("Coffees made since cleaning: " + coffeesMade);
    }

    public boolean isCleaningRequired() {
        return cleaningRequired;
    }
}
