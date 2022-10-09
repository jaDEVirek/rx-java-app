package org.jadevirek;


import java.util.Arrays;

public class Animal {
    public static void testClassMethod() {
        System.out.println("Class" + " method in Animal.");
    }
    public void testInstanceMethod() {

    }
    public Animal() {
        System.out.println("Constructor " + " method in Animal.");
        testClassMethod();
    }
}

class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The class method" + " in Cat.");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method" + " in Cat.");
    }

    public static void main(String[] args) {
        int[] liczby = {1, 2, 3 , 4, 5, 6, 7 , 8, 9, 10};
        int suma = 0;
        System.out.println(Arrays.stream(liczby).sum());
    }
}
