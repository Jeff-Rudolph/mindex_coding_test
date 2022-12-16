package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import jdk.internal.org.jline.utils.Log;
import com.mindex.challenge.dao.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportingStructureImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String id){
        //changed log message a little for my sake during debugging
        LOG.debug("Creating Employee object with id [{}]",id);

        //lookup employee in the database
        Employee employee = employeeRepository.findByEmployeeId(id);

        LOG.debug("Creating ReportingStructure object");

        //instantiate the root node of our Tree-like data structure
        ReportingStructure reportingStructure = new ReportingStructure();

        reportingStructure.setEmployee(employee);

        int numberUniqueSubEmployees = getNumberUniqueEmployeeIDs(getAllSubEmployees(reportingStructure.getEmployee().getEmployeeId()));
        reportingStructure.setNumberOfReports(numberUniqueSubEmployees);

        return reportingStructure;

    }

    //grab all direct reports of the current Employee node
    //then go through each child Employee, add to list then call method on said node.
    //Recursion stops when the function reaches leaf nodes (directReportList == null)
    private ArrayList<String> getAllSubEmployees(String id){
        //pull all employee info from the database each time
        Employee employee = employeeRepository.findByEmployeeId(id);
        ArrayList<String> children = new ArrayList<>();
        List<Employee> directReportList = employee.getDirectReports();
        if(directReportList == null){
            return children; //return empty list if no direct reports
       }
        for(Employee e: directReportList) {
            children.add(e.getEmployeeId());
            //recursive call
            children.addAll(getAllSubEmployees(e.getEmployeeId()));
        }
        return children;
    }

    private int getNumberUniqueEmployeeIDs(ArrayList<String> allSubEmployees){
        ArrayList<String> uniqueList = new ArrayList<>();
        for (String s: allSubEmployees) {
            if(!uniqueList.contains(s)){
                uniqueList.add(s);
            }
        }
        return uniqueList.size();
    }

}
