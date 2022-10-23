package org.jadevirek.serviceconsumer;

import static java.util.Map.entry;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompanyService implements FinancialOperations {

    private static final List<Employee> COMPANY_EMPLOYEES = Arrays.asList(
            new Employee(1, "Tommy", "Amber", new BigDecimal(0)), new Employee(2, "Bob", "Weler", new BigDecimal(0)),
            new Employee(3, "Alice", "Parker", new BigDecimal(0)), new Employee(4, "Suzan", "Alonso", new BigDecimal(0)));

    private static final Map<String, BigDecimal> salaryContainer = Map.ofEntries(
            entry("Weler", new BigDecimal("3100")),
            entry("Amber", new BigDecimal("5200")),
            entry("Parker", new BigDecimal("8000")),
            entry("Alonso", new BigDecimal("3850"))
    );

    @Override
    public CompletionStage<List<Employee>> hiredEmployees() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("[Service]: Fetching Employees");
            return COMPANY_EMPLOYEES;
        });
    }

    @Override
    public CompletionStage<BigDecimal> getSalary(long employeeId) {
        return CompletableFuture.supplyAsync(COMPANY_EMPLOYEES.stream().filter(employee -> Objects.equals(employee.getId(), employeeId)).peek((employee) -> System.out.println("[Service]: Fetching Salary for Employee: " + employee)).map(
                employee -> salaryContainer.get(employee.getlName())).reduce((a, b) -> null)::get);
    }
}
