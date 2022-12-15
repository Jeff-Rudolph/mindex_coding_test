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
    public int read(String id){
        //changed log message a little for my sake during debugging
        LOG.debug("Creating Employee object with id [{}]",id);

        //lookup employee in the database
        Employee employee = employeeRepository.findByEmployeeId(id);

        LOG.debug("Creating ReportingStructure object");

        //instantiate the root node of our Tree-like data structure
        //NOTE this is all really just a placeholder here to make sure I was able to print something to the browser
        ReportingStructure reportingStructure = new ReportingStructure(employee);
        int numberUniqueSubEmployees = getNumberUniqueEmployeeIDs(getAllSubEmployees(reportingStructure.getEmployee()));
        reportingStructure.setNumberOfReports(numberUniqueSubEmployees);
        return reportingStructure.getNumberOfReports();

    }

    //grab all direct reports of the current Employee node
    //then go through each child Employee, add to list then call method on said node.
    //Recursion stops when the function reaches leaf nodes (directReportList == null)
    private static ArrayList<Employee> getAllSubEmployees(Employee employee){
        ArrayList<Employee> children = new ArrayList<>();
        List<Employee> directReportList = employee.getDirectReports();
        if(directReportList == null){
            return children;
        }
        for(Employee emp: directReportList) {
            children.add(emp);
            children.addAll(getAllSubEmployees(emp));
        }
        return children;
    }

    private int getNumberUniqueEmployeeIDs(ArrayList<Employee> allSubEmployees){
        ArrayList<String> uniqueList = new ArrayList<>();
        for (Employee emp: allSubEmployees) {
            if(!uniqueList.contains(emp.getEmployeeId())){
                uniqueList.add(emp.getEmployeeId());
            }
        }
        return uniqueList.size();
    }

}
