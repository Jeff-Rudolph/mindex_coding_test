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
        if(employee.getDirectReports() == null){
            numberOfReports = 0;
        }
        else{
            numberOfReports = employee.getDirectReports().size();
        }
    }

//    private int findNumberOfReports(List<Employee> directReports) {
//        //return 0 if no one reports to this employee
//        if(directReports == null){
//            return 0;
//        }
//        List<Employee> uniqueList = new List<Employee>() {
//        }
//        for (:
//             ) {
//
//        }
//    }
//    private ArrayList retrieveAllBelowEmployee(Employee employee){
//        ArrayList masterList = new ArrayList();
//        if(employee.getDirectReports() == null){
//            return new ArrayList();
//        }
//        else{
//            masterList.add(employee.getDirectReports());
//            for (Employee emp: masterList) {
//                String id = emp.getEmployeeId();
//
//
//            }
//        }
//    }
    //getter methods, probably won't need them delete later if so.
    public Employee getEmployee() {
        return employee;
    }
    public int getNumberOfReports(){
        return numberOfReports;
    }
}
