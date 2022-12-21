package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CompensationController {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id){
        LOG.debug("Received read request for Compensation of EmployeeId [{}]",id);
        return compensationService.read(id);
    }

    @PostMapping("/compensation")
    public Compensation create(@PathVariable Compensation compensation){

        LOG.debug("Received create request for Compensation of EmployeeId [{}]",compensation.getEmployee().getEmployeeId());
        return compensationService.create(compensation);
    }


}
