package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import jdk.internal.org.jline.utils.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    //automatically injecting singleton instance of service
    @Autowired
    private ReportingStructureService reportingStructureService;

    //passing id from url into method from reportingStructureService where it will be used to lookup and instantiate
    //Employee object.
    @GetMapping("/reportingstructure/{id}")
    public ReportingStructure read(@PathVariable String id){
        LOG.debug("Received create request for Employee object creation for id [{}]", id);

        return reportingStructureService.read(id);

    }



}
