package org.jadevirek;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class TestSTream {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
    listOfNumbers.stream().sequential().forEach(number ->
        System.out.println(number + " -> " + Thread.currentThread().getName()));

    listOfNumbers.parallelStream().forEach(number ->
        System.out.println(number + " " + Thread.currentThread().getName()));

    ForkJoinPool customThreadPool = new ForkJoinPool(4);
    int sum = customThreadPool.submit(
        () -> listOfNumbers.parallelStream().reduce(5, Integer::sum)).join();
    System.out.println(sum);
    customThreadPool.shutdown();
    JavaMemoryModel.();
    final JavaMemoryModel javaMemoryModel;
    javaMemoryModel = new JavaMemoryModel();

  }


    static class JavaMemoryModel {
    static String name;
    private  String age;
//    public static void exampleRunner(){
//
//    }
     void nonStatic(){

     }
  }
}
