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
        //NOTE this is all really just a place holder here to make sure I was able to print something to the browser
        ReportingStructure reportingStructure = new ReportingStructure(employee);

        if(reportingStructure.getNumberOfReports() == 0){
            return 0;
        }
        else{ //dummy, just putting this here to make sure I got the url part handled
            //return reportingStructure.getNumberOfReports();
            return 3;
        }

    }
}
