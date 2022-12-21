package com.mindex.challenge.data;

import java.time.LocalDate;
public class Compensation {
    private Employee employee;
    private int salary;
    private LocalDate effectiveDate;

    public Compensation(){

    }

    public Employee getEmployee() {
        return employee;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDate(int year, int month, int day) {
        this.effectiveDate = LocalDate.of(year, month, day);

    }
}
