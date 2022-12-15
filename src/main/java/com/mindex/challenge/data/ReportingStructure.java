package com.mindex.challenge.data;

import java.util.ArrayList;
import java.util.List;

public class ReportingStructure {
    //two fields that were stipulated in requirements
    private Employee employee;
    private int numberOfReports;

    //reporting structure always starts from a given employee so will take an Employee as input
    //and calculate numberOfReports from there
    public ReportingStructure(Employee employee) {
        this.employee = employee;
    }

    //getter methods, probably won't need them delete later if so.
    public Employee getEmployee() {
        return employee;
    }
    public int getNumberOfReports(){
        return numberOfReports;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
