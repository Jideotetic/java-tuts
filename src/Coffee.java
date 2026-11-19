package src;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record Coffee(String name, int water, int milk, int beans, int cost) {
    public static @Nullable Coffee getCoffee(@NotNull String choice) {
        return switch (choice) {
            case "1" -> new Coffee("espresso", 250, 0, 16, 4);
            case "2" -> new Coffee("latte", 350, 75, 20, 7);
            case "3" -> new Coffee("cappuccino", 200, 100, 12, 6);
            default -> null;
        };
    }
}
