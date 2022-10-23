package org.jadevirek.serviceconsumer;

import java.math.BigDecimal;

public class Employee {
    private long id;
    private  String fName;
    private  String lName;
    private BigDecimal salary;

    public Employee(long id, String fName, String lName, BigDecimal salary) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
    }

    public Employee setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getlName() {
        return lName;
    }

    @Override public String toString() {
      String sb = "Employee{" + "iD="
          + id
          + ", fName='"
          + fName
          + '\''
          + ", lName='"
          + lName
          + '\''
          + ", salary="
          + salary
          + '}';
      return sb;
    }
}
