package src;

public class Coffee {
    private final String name;
    private final int water;
    private final int milk;
    private final int beans;
    private final int cost;

    public Coffee(String name, int water, int milk, int beans, int cost) {
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCost() {
        return cost;
    }

    public static Coffee getCoffee(String choice) {
        return switch (choice) {
            case "1" -> new Coffee("espresso", 250, 0, 16, 4);
            case "2" -> new Coffee("latte", 350, 75, 20, 7);
            case "3" -> new Coffee("cappuccino", 200, 100, 12, 6);
            default -> null;
        };
    }
}
