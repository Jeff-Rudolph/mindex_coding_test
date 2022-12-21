package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Compensation create(@RequestBody Compensation compensation){

        LOG.debug("Received create request for Compensation of EmployeeId [{}]",compensation.getEmployee().getEmployeeId());
        return compensationService.create(compensation);
    }
    //js to send a post request with a fully filled out Employee object for employee data field.
//    (async function createComp() {
//        let employee = {"employeeId" : "16a596ae-edd3-4847-99fe-c4518e82c86f",
//                "firstName" : "John",
//                "lastName" : "Lennon",
//                "position" : "Development Manager",
//                "department" : "Engineering",
//                "directReports" : [
//        {
//            "employeeId" : "b7839309-3348-463b-a7e3-5de1c168beb3"
//        },
//        {
//            "employeeId": "03aa1462-ffa9-4978-901b-7c001562cf6f"
//        }
//    				]};
//        let compensation = {"employee": employee, "salary": 80000, "effectiveDate" : "2020-05-01"};
//
//
//        await fetch("http://localhost:8080/compensation", {
//                method: "POST",
//                headers: {
//            "Accept": "application/json",
//                    "Content-Type": "application/json"
//        },
//        body: JSON.stringify(compensation)
//                        })
//                        .then(result => result.text())
//                        .then(text => alert(text));
//    })();


}
