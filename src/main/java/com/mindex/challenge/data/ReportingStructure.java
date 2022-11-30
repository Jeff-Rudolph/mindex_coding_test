package com.mindex.challenge.data;

import java.util.List;

public class ReportingStructure {
    private Employee employee;
    private int numberOfReports;

    //reporting structure always starts from a given employee so will take an Employee as input
    //and calculate numberOfReports from there
    public ReportingStructure(Employee employee) {
        this.employee = employee;
        numberOfReports = findNumberOfReports(employee.getDirectReports());
    }

    private int findNumberOfReports(List<Employee> directReports) {
        //return 0 if no one reports to this employee
        if(directReports == null){
            return 0;
        }
        List<Employee> uniqueList = new List<Employee>() {
        }
        for (:
             ) {

        }
    }

    public Employee getEmployee() {
        return employee;
    }
    public int getNumberOfReports(){

    }
}
