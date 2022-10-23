package org.jadevirek.serviceconsumer;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletionStage;

public interface FinancialOperations {
    CompletionStage<List<Employee>> hiredEmployees();
    CompletionStage<BigDecimal> getSalary(long employeeId);
}
