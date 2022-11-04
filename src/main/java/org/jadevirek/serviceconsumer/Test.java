package org.jadevirek.serviceconsumer;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Jak masz na imię?");
      String firstName = scan.nextLine();

      System.out.println("Witaj " + firstName);
      String firstName2 = scan.nextLine();
      System.out.println(firstName2);
    }

}
