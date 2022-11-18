package org.jadevirek.shifters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShiftCaseEx1 {

  static char[] letters = {'A', 'B' , 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

  public static void main(String[] args) {
    shiftRight(letters);
    List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);

    List<Integer> nums = numbers.parallelStream()

        .map(n -> n * 2)

        .peek(n -> System.out.printf("%s processing %d%n", Thread.currentThread().getName(), n))

        .sequential()

        .sorted()

        .collect(Collectors.toList());
  }

  public static void shiftRight( char [] array ) {
    char last = array[array.length-1];
    for( int index =array.length-2; index >= 0 ; index-- )
      array[index+1] = array [index];
    array[0] = last;
    System.out.print("\n Result Array: " + Arrays.toString(array));
  }

}
