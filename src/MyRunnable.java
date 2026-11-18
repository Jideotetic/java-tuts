package src;

class ExampleRunnable implements Runnable {
    public void run() {
        System.out.println("This is my runnable thread running!");
        for (int i = 1; i <= 1_000_000_000; i++) {
            System.out.println("Count: " + i);
        }
    }
}

public class MyRunnable {
    static void main(String[] args) {
        ExampleRunnable myRunnable = new ExampleRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
