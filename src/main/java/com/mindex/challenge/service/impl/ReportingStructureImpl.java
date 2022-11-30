package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import jdk.internal.org.jline.utils.Log;
import com.mindex.challenge.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportingStructureImpl implements ReportingStructureService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public int read(String id){
        Log.debug("Creating Employee object with id [{}]",id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        Log.debug("Creating ReportingStructure object");

        ReportingStructure reportingStructure = new ReportingStructure(employee);

    }
}
