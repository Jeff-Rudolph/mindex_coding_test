package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
public class Compensation {
    //data fields from requirements
    private Employee employee; //this will be the primary key for our db as it is unique
    private int salary;
    //Formatting the LocalDate to be able to come into the Post request in the following pattern as a String
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate effectiveDate;

    //empty constructor
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


    public void setEffectiveDate(String dateString) {
        this.effectiveDate = LocalDate.parse(dateString);

    }
}
