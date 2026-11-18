package src;

class ExampleThread extends Thread {
    public void run() {
        System.out.println("This is my thread running!");
        for (int i = 1; i <= 1_000_000_000; i++) {
            System.out.println("Count: " + i);
        }
    }
}

public class MyThread {
    static void main(String[] args) {
        ExampleThread thread = new ExampleThread();
        thread.start();
    }
}
