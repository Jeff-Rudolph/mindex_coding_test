package com.mindex.challenge.data;

import java.util.ArrayList;
import java.util.List;

public class ReportingStructure {
    //two fields that were stipulated in requirements
    private Employee employee; //root of the tree structure
    private int numberOfReports; //will be calculated by methods

    //empty constructor
    public ReportingStructure() {
    }

    public Employee getEmployee() {
        return employee;
    }
    public int getNumberOfReports(){
        return numberOfReports;
    }

    //not deep copy but won't matter for this case
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
