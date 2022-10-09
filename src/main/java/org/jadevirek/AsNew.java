package org.jadevirek;

public interface AsNew {

    public static void testedStatic(){

    }
    public  default void tested() {
        System.out.println();
    }
}
