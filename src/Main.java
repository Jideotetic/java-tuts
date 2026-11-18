package src;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static void main(String[] arg) {

        Person person = new Person();

        person.speak();

        AtomicInteger visits = new AtomicInteger(0);
        visits.incrementAndGet();
        int totalVisits = visits.get();
        System.out.println(totalVisits);


    }
}