package org.jadevirek.serviceconsumer;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

public class ApplicationRunner {

  public static void main(String[] args) {
    CompanyService companyService = new CompanyService();

    ConsoleProgressBar.animate();
    CompletionStage<List<CompletionStage<Employee>>> listCompletionStage = companyService
        .hiredEmployees().thenApplyAsync(employees ->
            employees.stream()
                .map(employee -> companyService.getSalary(employee.getId())
                    .thenApplyAsync(employee::setSalary))
                .collect(toList()));

    System.out.println(Arrays.toString(listCompletionStage.toCompletableFuture().join().stream()
        .peek(stage -> stage
            .thenAccept(employee -> System.out.println("Filled employee: " + employee)))
        .map(elem -> elem.toCompletableFuture().join()).toArray()));
  }
  class ConsoleProgressBar {
    static void animate() {
      char[] animationChars = new char[]{'|', '/', '-', '\\'};

      for (int i = 0; i <= 100; i++) {
        System.out.print("Processing: " + i + "% " + animationChars[i % 4] + "\r");

        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      System.out.println("Processing: Done!");
    }
  }
}
