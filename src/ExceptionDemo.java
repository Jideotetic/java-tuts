package src;



class CementMixer implements AutoCloseable {
    public void startMixer() throws RuntimeException {
        System.out.println("Mixer started...");
        throw new RuntimeException("Mixer overload!");
    }

    @Override
    public void close() {
        System.out.println("Mixer stopped and cleaned up.");
    }
}

public class ExceptionDemo {
     static void main(String[] args) {
        try (CementMixer mixer = new CementMixer()) {
            mixer.startMixer();
        } catch (RuntimeException e) {
            System.out.println("Problem occurred: " + e.getMessage());
        }
    }
}

