package src;

public class Person {
    String name;
    int age;
    volatile boolean active = true;

    void speak() {
        System.out.println("My name is " + name + " and I am " + age + " years old.");
    }
}
